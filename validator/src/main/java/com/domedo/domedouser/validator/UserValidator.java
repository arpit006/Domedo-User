package com.domedo.domedouser.validator;

import com.domedo.commons.validator.IDomedoValidator;
import com.domedo.domedouser.dao.UserRepository;
import com.domedo.domedouser.entities.User;
import com.domedo.objects.exceptions.DomedoDataException;
import com.domedo.objects.pojos.ErrorCodes;
import com.domedo.objects.util.CustomPrecondition;
import com.domedo.objects.vos.DomedoRegisterReqVo;
import com.domedo.objects.vos.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Arpit Srivastava <a> mailTo: iarpitsrivastava06@gmail.com</a>
 */
@Component
public class UserValidator implements IDomedoValidator<User, UserVo> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void validateSave(UserVo vo) {
        //validate name
        CommonValidator.validateName(vo.getFirstName() + " " + vo.getLastName());
        //validate email
        CommonValidator.validateEmail(vo.getEmail());
        //validate phoneNumber
        CommonValidator.validatePhoneNumber(vo.getPhoneNumber());
        //email dedup check
        CustomPrecondition.checkArgument(!uniqueEmailValidator(vo.getEmail()).isPresent(),
                () -> new DomedoDataException(ErrorCodes.EMAIL_ALREADY_EXISTS));
    }

    @Override
    public void validateUpdate(User user, UserVo vo) {

    }

    public void validateLoginOrRegister(DomedoRegisterReqVo vo) {
        String phoneNumber = vo.getPhoneNumber();
        CommonValidator.validatePhoneNumber(phoneNumber);
    }

    private Optional<User> uniqueEmailValidator(String email) {
        return userRepository.findByEmail(email);
    }
}
