package com.domedo.domedouser.entities;

import com.domedo.commons.entity.DomedoBaseEntity;
import com.domedo.domedouser.du_common.CustomHouseIdGenerator;
import com.domedo.objects.enums.City;
import com.domedo.objects.enums.Country;
import com.domedo.objects.enums.PinCode;
import com.domedo.objects.enums.States;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

/**
 * @author Arpit Srivastava <a> mailTo: iarpitsrivastava06@gmail.com</a>
 */
@Entity
@Table(name = "USER_ADDRESS")
@Data
@EqualsAndHashCode(callSuper = false)
@TypeDef(
        name = "json",
        typeClass = JsonStringType.class
)
@ToString
@Slf4j
public class UserAddress extends DomedoBaseEntity {

//    @GenericGenerator(name = "HOUSE_ID_GEN", strategy = "com.domedo.domedouser.du_common.CustomHouseIdGenerator")
//    @GeneratedValue(generator = "HOUSE_ID_GEN")
//    @GeneratorType(type = CustomHouseIdGenerator.class, when = GenerationTime.INSERT)
    @Column(name = "HOUSE_HOLD_ID")
    private String houseHoldId;

    @Column(name = "HOUSE_NICK_NAME")
    private String houseNickName;

    @Column(name = "HOUSE_NO")
    private String houseNo;

    @Column(name = "STREET_NAME")
    private String streetName;

    @Column(name = "AREA")
    private String area;

    @Enumerated(EnumType.STRING)
    @Column(name = "CITY")
    private City city;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATE")
    private States state;

    @Enumerated(EnumType.STRING)
    @Column(name = "COUNTRY")
    private Country country;

    @Enumerated(EnumType.STRING)
    @Column(name = "PINCODE")
    private PinCode pinCode;

    @Type(type = "json")
    private List<String> mapsTo;

    @Column(name = "IS_ACTIVE")
    private boolean isActive = true;

    @Version
    @Column(name = "VERSION")
    private Long version;

    @PrePersist
    public void prePersist() {
        this.houseHoldId = "HOUSE-" + UUID.randomUUID().toString();
        log.info("User Address Entity: [{}]", this.toString());
    }
}
