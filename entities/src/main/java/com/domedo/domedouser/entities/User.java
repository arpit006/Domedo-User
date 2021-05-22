package com.domedo.domedouser.entities;

import com.domedo.commons.entity.DomedoBaseEntity;
import com.domedo.objects.enums.CountryCode;
import com.domedo.objects.enums.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

/**
 * @author Arpit Srivastava <a> mailTo: iarpitsrivastava06@gmail.com</a>
 */
@Entity
@Table(name = "DOMEDO_USER")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
@Slf4j
public class User extends DomedoBaseEntity {

//    @NotBlank(message = "First Name cannot be blank")
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

//    @Past(message = "Date of Birth should be a valid date before current date")
    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "GENDER")
    private Gender gender;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "COUNTRY_CODE")
    private CountryCode countryCode;

    @NotBlank(message = "Phone number is required")
    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

//    @Email(message = "Please enter a valid email ID")
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "IS_PHONE_NUMBER_VERIFIED")
    private boolean isPhoneNumberVerified = true;

    @Column(name = "IS_EMAIL_VERIFIED")
    private boolean isEmailVerified = true;

    @Column(name = "IS_ACCOUNT_FULLY_VERIFIED")
    private boolean isAccountFullyVerified;

    @Column(name = "IS_ACTIVE")
    private boolean isActive = true;

    //many to many mapping of user-id and house-hold-id
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ADDRESS_MAP",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID")})
    private List<UserAddress> addressList;

    @Version
    private Long version;

    @PrePersist
    public void prePersist() {
        verifyAccountFullyVerified();
        log.info("User Entity: [{}]", this.toString());
    }

    @PreUpdate
    public void preUpdate() {
        verifyAccountFullyVerified();
    }

    private void verifyAccountFullyVerified() {
        if (StringUtils.isNoneBlank(firstName, lastName, phoneNumber, email, gender.name())) {
            if (isPhoneNumberVerified && isEmailVerified) {
                this.isAccountFullyVerified = true;
            }
        }
    }
}
