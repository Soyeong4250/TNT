package com.ssafy.tnt.api.controller;

import com.ssafy.tnt.api.request.UserLoginPostReq;
import com.ssafy.tnt.api.response.UserLoginPostRes;
import com.ssafy.tnt.api.service.UserService;
import com.ssafy.tnt.common.util.JwtTokenUtil;
import com.ssafy.tnt.db.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 로그인, 소셜 로그인 등 인증 관련 컨트롤러
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * User ID 와 Password 를 통해 JWT 생성 방식의 로그인
     */
    @PostMapping("/login")
    public ResponseEntity<UserLoginPostRes> login(@RequestBody UserLoginPostReq loginInfo) {
        String userId = loginInfo.getUser_id();
        String password = loginInfo.getUser_pwd();

        User user = userService.getUserByUserId(userId);
        if(passwordEncoder.matches(password, user.getPassword())) {
            return ResponseEntity.ok(UserLoginPostRes.of(200, "Success", JwtTokenUtil.getToken(userId)));
        }
        return ResponseEntity.status(401).body(UserLoginPostRes.of(401, "Invalid Password", null));
    }

}
