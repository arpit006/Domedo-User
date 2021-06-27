package com.domedo.domedouser.service;

import com.domedo.commons.service.IDomedoService;
import com.domedo.domedouser.entities.User;
import com.domedo.objects.vos.DomedoRegisterReqVo;
import com.domedo.objects.vos.DomedoRegisterRespVo;
import com.domedo.objects.vos.UserVo;

/**
 * @author Arpit Srivastava <a> mailTo: iarpitsrivastava06@gmail.com</a>
 */
public interface IUserService extends IDomedoService<User, UserVo> {

    /**
     * This method will take in the entered OTP against mobile number and will check
     * if the OTP entered matches with the generated OTP
     * @param vo {@link DomedoRegisterReqVo}
     * @return {@link DomedoRegisterRespVo}
     */
    DomedoRegisterRespVo verifyUser(DomedoRegisterReqVo vo);

    /**
     * This method will take in mobile number and will generate an OTP which will be sent to the registered mobile number.
     * OTP will have a timeout post which the same OTP will not remain valid and hence it needs to be generated again to validate.
     * @param vo {@link DomedoRegisterReqVo}
     * @return Success message
     */
    String loginUser(DomedoRegisterReqVo vo);
}
