package com.domedo.domedouser.validator;

import com.domedo.commons.validator.IDomedoValidator;
import com.domedo.domedouser.entities.User;
import com.domedo.objects.constants.AppConstants;
import com.domedo.objects.exceptions.DomedoDataException;
import com.domedo.objects.pojos.ErrorCodes;
import com.domedo.objects.util.CustomPrecondition;
import com.domedo.objects.vos.DomedoRegisterReqVo;
import com.domedo.objects.vos.UserVo;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;

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

    public void validateLoginOrRegister(DomedoRegisterReqVo vo) {
        String phoneNumber = vo.getPhoneNumber();
        Matcher matcher = AppConstants.NUMBER_PATTERN.matcher(phoneNumber);
        CustomPrecondition.checkArgument(matcher.matches(),
                () -> new DomedoDataException(ErrorCodes.INVALID_PHONE_NUMBER));
    }
}
