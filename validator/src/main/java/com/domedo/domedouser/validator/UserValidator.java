package com.domedo.domedouser.validator;

import com.domedo.commons.validator.IDomedoValidator;
import com.domedo.domedouser.entities.User;
import com.domedo.objects.vos.UserVo;
import org.springframework.stereotype.Component;

/**
 * @author Arpit Srivastava <a> mailTo: iarpitsrivastava06@gmail.com</a>
 */
@Component
public class UserValidator implements IDomedoValidator<User, UserVo> {

    @Override
    public void validateSave(UserVo vo) {

    }

    @Override
    public void validateUpdate(User user, UserVo vo) {

    }
}
