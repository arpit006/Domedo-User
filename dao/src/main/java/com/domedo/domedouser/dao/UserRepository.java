package com.domedo.domedouser.dao;

import com.domedo.commons.repository.IDomedoRepository;
import com.domedo.domedouser.entities.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Arpit Srivastava <a> mailTo: iarpitsrivastava06@gmail.com</a>
 */
@Repository
public interface UserRepository extends IDomedoRepository<User> {

    Optional<User> findByPhoneNumber(String phoneNumber);
}
