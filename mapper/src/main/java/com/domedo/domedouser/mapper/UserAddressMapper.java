package com.domedo.domedouser.mapper;

import com.domedo.commons.mapper.AbstractDomedoMapper;
import com.domedo.domedouser.entities.UserAddress;
import com.domedo.objects.enums.City;
import com.domedo.objects.enums.Country;
import com.domedo.objects.enums.PinCode;
import com.domedo.objects.enums.States;
import com.domedo.objects.vos.UserAddressVo;
import com.domedo.objects.vos.UserVo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Arpit Srivastava <a> mailTo: iarpitsrivastava06@gmail.com</a>
 */
@Component
public class UserAddressMapper extends AbstractDomedoMapper<UserAddress, UserAddressVo> {

    @Override
    public UserAddress map(UserAddressVo vo) {
        UserAddress add = new UserAddress();
        add.setHouseNo(vo.getHouseNo());
        add.setStreetName(vo.getStreetName());
        add.setArea(vo.getArea());
        add.setHouseNickName(vo.getHouseNickName());
        add.setCity(City.valueOf(vo.getCity()));
        add.setState(States.valueOf(vo.getState()));
        add.setCountry(Country.valueOf(vo.getCountry()));
        add.setPinCode(PinCode.getIfPincodeExists(vo.getPinCode()));
        return add;
    }

    @Override
    public UserAddressVo map(UserAddress address) {
        UserAddressVo vo = new UserAddressVo();
        vo.setHouseHoldId(address.getHouseHoldId());
        vo.setHouseNo(address.getHouseNo());
        vo.setStreetName(address.getStreetName());
        vo.setArea(address.getArea());
        vo.setHouseNickName(address.getHouseNickName());
        vo.setCity(address.getCity().name());
        vo.setState(address.getState().name());
        vo.setCountry(address.getCountry().name());
        vo.setPinCode(address.getPinCode().name());
        return vo;
    }

    public List<UserAddress> mapVoList(List<UserAddressVo> userVos) {
        return userVos.stream().map(this::map).collect(Collectors.toList());
    }

    public List<UserAddressVo> mapEntityList(List<UserAddress> userAddresses) {
        return userAddresses.stream().map(this::map).collect(Collectors.toList());
    }
}
