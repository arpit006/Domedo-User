package com.domedo.domedouser.du_common;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 * @author Arpit Srivastava <a> mailTo: iarpitsrivastava06@gmail.com</a>
 */
public class UserServiceAuditAware implements AuditorAware<String> {

    // TODO: change this logic to get from Security Context
    @Override
    public Optional<String> getCurrentAuditor() {
//        return Optional.ofNullable(DomedoStaffUtil.getDomedoStaffName());
        return Optional.ofNullable("arpit");
    }

}
