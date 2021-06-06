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

    DomedoRegisterRespVo verifyUser(DomedoRegisterReqVo vo);

    String loginUser(DomedoRegisterReqVo vo);
}
