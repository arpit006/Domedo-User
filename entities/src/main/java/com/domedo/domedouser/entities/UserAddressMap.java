package com.domedo.domedouser.entities;

import com.domedo.commons.entity.DomedoBaseEntity;
import com.domedo.domedouser.entities.composite.UserAddressId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Arpit Srivastava <a> mailTo: iarpitsrivastava06@gmail.com</a>
 */
//@Entity
//@Table(name = "USER_ADDRESS_MAP")
//@Data
//@NoArgsConstructor
//@EqualsAndHashCode(callSuper = false)
public class UserAddressMap extends DomedoBaseEntity {

//    @EmbeddedId
//    private UserAddressId userAddressId;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "ADDRESS_ID")
    private String addressId;
}
