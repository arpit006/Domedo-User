package com.domedo.domedouser.validator;

import com.domedo.commons.validator.IDomedoValidator;
import com.domedo.domedouser.entities.UserAddress;
import com.domedo.objects.vos.UserAddressVo;
import org.springframework.stereotype.Component;

/**
 * @author Arpit Srivastava <a> mailTo: iarpitsrivastava06@gmail.com</a>
 */
@Component
public class UserAddressValidator implements IDomedoValidator<UserAddress, UserAddressVo> {

    @Override
    public void validateSave(UserAddressVo vo) {

    }

    @Override
    public void validateUpdate(UserAddress userAddress, UserAddressVo vo) {

    }
}
