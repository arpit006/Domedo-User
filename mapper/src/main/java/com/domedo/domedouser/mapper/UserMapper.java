package com.domedo.domedouser.mapper;

import com.domedo.commons.mapper.AbstractDomedoMapper;
import com.domedo.domedouser.entities.User;
import com.domedo.objects.enums.Gender;
import com.domedo.objects.vos.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Arpit Srivastava <a> mailTo: iarpitsrivastava06@gmail.com</a>
 */
@Component
public class UserMapper extends AbstractDomedoMapper<User, UserVo> {

    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    public User map(UserVo vo) {
        User user = new User();
        user.setFirstName(vo.getFirstName());
        user.setLastName(vo.getLastName());
        user.setPhoneNumber(vo.getPhoneNumber());
        user.setEmail(vo.getEmail());
        user.setGender(Gender.fromGender(vo.getGender()));
        user.setAddressList(userAddressMapper.mapVoList(vo.getAddressList()));
        return user;
    }

    @Override
    public UserVo map(User user) {
        UserVo vo = new UserVo();
        vo.setFirstName(user.getFirstName());
        vo.setLastName(user.getLastName());
        vo.setPhoneNumber(user.getPhoneNumber());
        vo.setEmail(user.getEmail());
        vo.setGender(user.getGender().name());
        vo.setAddressList(userAddressMapper.mapEntityList(user.getAddressList()));
        vo.setAccountFullyVerified(user.isAccountFullyVerified());
        vo.setPhoneNumberVerified(user.isPhoneNumberVerified());
        vo.setEmailVerified(user.isEmailVerified());
        return vo;
    }
}
