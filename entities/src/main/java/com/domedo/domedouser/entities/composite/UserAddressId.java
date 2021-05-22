package com.domedo.domedouser.entities.composite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Arpit Srivastava <a> mailTo: iarpitsrivastava06@gmail.com</a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserAddressId implements Serializable {

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "HOUSE_ID")
    private String houseId;
}
