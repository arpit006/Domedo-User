package com.domedo.domedouser.validator;

import com.domedo.objects.constants.AppRegex;
import com.domedo.objects.exceptions.DomedoDataException;
import com.domedo.objects.pojos.ErrorCodes;
import com.domedo.objects.util.CustomPrecondition;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;

/**
 * @author Arpit Srivastava <a> mailTo: iarpitsrivastava06@gmail.com</a>
 */
public class CommonValidator {

    private CommonValidator() {
        throw new IllegalArgumentException("Common Validator is a static Class");
    }

    public static void validateName(String name) {
        if (StringUtils.isNotBlank(name)) {
            Matcher matcher = AppRegex.NAME_PATTERN.matcher(name);
            CustomPrecondition.checkArgument(matcher.matches(), () -> new DomedoDataException(ErrorCodes.INVALID_NAME));
        }
    }

    public static void validateEmail(String email) {
        if (StringUtils.isNotBlank(email)) {
            Matcher matcher = AppRegex.VALID_EMAIL_PATTERN.matcher(email);
            CustomPrecondition.checkArgument(matcher.matches(), () -> new DomedoDataException(ErrorCodes.INVALID_EMAIL));
        }
    }

    public static void validatePhoneNumber(String phoneNumber) {
        if (StringUtils.isNotBlank(phoneNumber)) {
            Matcher matcher = AppRegex.NUMBER_PATTERN.matcher(phoneNumber);
            CustomPrecondition.checkArgument(matcher.matches(),
                    () -> new DomedoDataException(ErrorCodes.INVALID_PHONE_NUMBER));
        }
    }

}
