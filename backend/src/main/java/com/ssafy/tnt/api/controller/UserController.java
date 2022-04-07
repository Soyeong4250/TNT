package com.ssafy.tnt.api.controller;

import com.ssafy.tnt.api.request.UserRegisterPostReq;
import com.ssafy.tnt.api.request.UserUpdatePutReq;
import com.ssafy.tnt.api.response.UserInfoGetRes;
import com.ssafy.tnt.api.service.UserService;
import com.ssafy.tnt.common.auth.TNTUserDetails;
import com.ssafy.tnt.common.model.response.BaseResponseBody;
import com.ssafy.tnt.db.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 회원 등록.
     * 등록 성공시 응답 코드 200을 보낸다.
     */
    @PostMapping("/register")
    public ResponseEntity<? extends BaseResponseBody> register(
            @RequestBody UserRegisterPostReq registerInfo) {
    	System.out.println(registerInfo.toString());
        User user = userService.createUser(registerInfo);

        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }

    /**
     * 회원 정보.
     * 요청 헤더 액세스 토큰이 포함된 경우에만 인증 처리가 실행되고,
     * 리턴되는 인증 정보 객체를 통해서 요청한 유저를 식별한다.
     * 액세스 토큰이 없다면 에러 발생
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserInfoGetRes> getUserInfo(@PathVariable String userId, Authentication authentication) {

        TNTUserDetails userDetails = (TNTUserDetails) authentication.getDetails();
        User user = userService.getUserByUserId(userId);

        return ResponseEntity.status(200).body(UserInfoGetRes.of(user));
    }

    /**
     * 아이디 중복 확인.
     */
    @GetMapping("/IdCheck/{ckId}")
    public ResponseEntity<Boolean> CheckDuplicateId(
            @PathVariable String ckId) {
        User user = userService.getUserByUserId(ckId);
        if(user!=null)
            return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
        else
            return new ResponseEntity<>(false,HttpStatus.ACCEPTED);
    }

    /**
     * 회원 삭제.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<? extends BaseResponseBody> deleteUser(@PathVariable String id) {

        userService.deleteByUserId(id);

        return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
    }

    /**
     * 회원 수정.
     */
    @PutMapping("/{id}")
    public ResponseEntity<? extends BaseResponseBody> updateUser(@PathVariable String id,@RequestBody UserUpdatePutReq userUpdatePutReq) {


        User user=userService.updateUser(id, userUpdatePutReq);
        if(user!=null)
            return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
        else
            return ResponseEntity.status(404).body(BaseResponseBody.of(404, "Fail"));
    }

}
