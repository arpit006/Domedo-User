package com.domedo.domedouser.service;

import com.domedo.basesdk.enums.HttpStatus;
import com.domedo.basesdk.pojo.BaseHttpResponse;
import com.domedo.commons.service.AbstractDomedoService;
import com.domedo.domedouser.dao.UserRepository;
import com.domedo.domedouser.du_common.helper.OtpRequestGenerator;
import com.domedo.domedouser.entities.User;
import com.domedo.domedouser.mapper.UserMapper;
import com.domedo.domedouser.validator.UserValidator;
import com.domedo.notificationservice.sdk.service.OtpRestCaller;
import com.domedo.objects.enums.RoleType;
import com.domedo.objects.exceptions.DomedoIntegrationException;
import com.domedo.objects.vos.DomedoRegisterReqVo;
import com.domedo.objects.vos.DomedoRegisterRespVo;
import com.domedo.objects.vos.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * This class will hold all Business logic for UserService
 *
 * @author Arpit Srivastava <a> mailTo: iarpitsrivastava06@gmail.com</a>
 */
@Service
@Slf4j
public class UserService extends AbstractDomedoService<User, UserVo> implements IUserService {

    private UserRepository userRepository;

    private UserMapper userMapper;

    private UserValidator userValidator;

    private OtpRestCaller otpRestCaller;

    public UserService(UserMapper userMapper, UserRepository userRepository, UserValidator userValidator, OtpRestCaller otpRestCaller) {
        super(userMapper, userRepository, userValidator);
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userValidator = userValidator;
        this.otpRestCaller = otpRestCaller;
    }

    @Override
    public DomedoRegisterRespVo verifyUser(DomedoRegisterReqVo vo) {
        String phoneNumber = vo.getPhoneNumber();
        String otp = vo.getOtp();
        userValidator.validateLoginOrRegister(vo);
        Optional<User> optionalUser = userRepository.findByPhoneNumber(phoneNumber);
        //validate OTP and return error in case of invalid OTP
        BaseHttpResponse response = otpRestCaller.verifyOtp(OtpRequestGenerator.makeVerifyOtpRequest(phoneNumber, otp));
        log.info("UserService: verifyUser() Response: [{}]", response);
        validateHttpResponse(response);
        if (!optionalUser.isPresent()) {
            //save user
            User user = createUser(phoneNumber);
            //mark phone number verified
            User persistedUser = saveUser(user);
        }
        //TODO complete this
//        Preconditions.checkArgument(optionalUser.isPresent(), "No user exists");
//        User user = optionalUser.get();
//        return new DomedoRegisterRespVo("An OTP is sent to your registered mobile Number. Please enter OTP to continue", RoleType.USER, "ajkljda-dasdnakjd-addadd-12jdqdasd-das1easd");
        return new DomedoRegisterRespVo("OTP validated successfully", RoleType.USER, "ajkljda-dasdnakjd-addadd-12jdqdasd-das1easd");
    }

    private void validateHttpResponse(BaseHttpResponse baseHttpResponse) {
        HttpStatus httpStatus = baseHttpResponse.getHttpStatus();
        if (httpStatus.getCode() > 399) {
            throw new DomedoIntegrationException(baseHttpResponse.getBody());
        }
    }

    @Override
    public String loginUser(DomedoRegisterReqVo vo) {
        String phoneNumber = vo.getPhoneNumber();
        userValidator.validateLoginOrRegister(vo);
        //send otp to phone Number
        BaseHttpResponse response = otpRestCaller.generateOtp(OtpRequestGenerator.makeGenerateOtpRequest(phoneNumber));
        log.info("UserService: loginUser() OtpSent on: Response: [{}]", response);
        return response.getBody();
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    private User createUser(String phoneNumber) {
        User user = new User();
        user.setPhoneNumber(phoneNumber);
        return user;
    }
}
