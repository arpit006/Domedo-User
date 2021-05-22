package com.domedo.domedouser.web.controller;

import com.domedo.commons.controller.DomedoRestController;
import com.domedo.commons.generator.DomedoResponseGenerator;
import com.domedo.commons.service.IDomedoService;
import com.domedo.domedouser.entities.User;
import com.domedo.domedouser.generator.UserResponseGenerator;
import com.domedo.domedouser.service.UserService;
import com.domedo.objects.vos.UserVo;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

//    @Autowired
    private UserService userService;

//    @Autowired
    private UserResponseGenerator userResponseGenerator;

    public UserController(UserService userService, UserResponseGenerator userResponseGenerator) {
        super(userService, userResponseGenerator);
        this.userService = userService;
        this.userResponseGenerator = userResponseGenerator;
    }


    @PostMapping(value = "/v2/user")
    public ResponseEntity<TempUserResp> process(HttpServletRequest httpServletRequest) {
        String client = httpServletRequest.getHeader("client");
        log.info("Incoming request from " + client + " for /api/v2");
        TempUserResp resp = new TempUserResp();
        resp.setName("Arpit Srivastava");
        resp.setAge(23);
        log.info("Response prepared. " + resp);
        return ResponseEntity.ok(resp);
    }

    @Data
    @ToString
    class TempUserResp {
        String name;
        int age;
    }
}
