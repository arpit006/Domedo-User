package com.domedo.domedouser.service;

import com.domedo.commons.mapper.AbstractDomedoMapper;
import com.domedo.commons.repository.IDomedoRepository;
import com.domedo.commons.service.AbstractDomedoService;
import com.domedo.commons.validator.IDomedoValidator;
import com.domedo.domedouser.dao.UserRepository;
import com.domedo.domedouser.entities.User;
import com.domedo.domedouser.mapper.UserMapper;
import com.domedo.domedouser.validator.UserValidator;
import com.domedo.objects.vos.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Arpit Srivastava <a> mailTo: iarpitsrivastava06@gmail.com</a>
 */
@Service
public class UserService extends AbstractDomedoService<User, UserVo> implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserValidator userValidator;


    public UserService(UserMapper userMapper, UserRepository userRepository, UserValidator userValidator) {
        super(userMapper, userRepository, userValidator);
    }
}
