package com.domedo.domedouser.web.controller;

import com.domedo.commons.controller.DomedoRestController;
import com.domedo.domedouser.entities.User;
import com.domedo.domedouser.generator.UserResponseGenerator;
import com.domedo.domedouser.service.IUserService;
import com.domedo.objects.vos.DomedoRegisterReqVo;
import com.domedo.objects.vos.DomedoRegisterRespVo;
import com.domedo.objects.vos.UserVo;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Arpit Srivastava <a> mailTo: iarpitsrivastava06@gmail.com</a>
 */
@RestController
@RequestMapping(value = "/api/v1/user")
@Slf4j
public class UserController extends DomedoRestController<User, UserVo> {

    private IUserService userService;

    private UserResponseGenerator userResponseGenerator;

    public UserController(IUserService userService, UserResponseGenerator userResponseGenerator) {
        super(userService, userResponseGenerator);
        this.userService = userService;
        this.userResponseGenerator = userResponseGenerator;
    }

    @PostMapping(value = "/verify", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DomedoRegisterRespVo> verifyUser(@RequestBody DomedoRegisterReqVo vo) {
        DomedoRegisterRespVo response = userService.verifyUser(vo);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> loginUser(@RequestBody DomedoRegisterReqVo vo) {
        String response = userService.loginUser(vo);
        return ResponseEntity.ok().body(response);
    }
}
