package com.ssafy.tnt.api.controller;

import com.ssafy.tnt.api.request.UserFindIdPostReq;
import com.ssafy.tnt.api.request.UserFindPwdPostReq;
import com.ssafy.tnt.api.request.UserRegisterPostReq;
import com.ssafy.tnt.api.request.UserUpdatePutReq;
import com.ssafy.tnt.api.response.UserFindIdPostRes;
import com.ssafy.tnt.api.response.UserFindPwdPostRes;
import com.ssafy.tnt.api.response.UserInfoGetRes;
import com.ssafy.tnt.api.service.MailService;
import com.ssafy.tnt.api.service.UserService;
import com.ssafy.tnt.common.auth.TNTUserDetails;
import com.ssafy.tnt.common.model.response.BaseResponseBody;
import com.ssafy.tnt.db.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final MailService mailService;
    /**
     * 회원 등록.
     * 등록 성공시 응답 코드 200을 보낸다.
     */
    @PostMapping("/register")
    public ResponseEntity<? extends BaseResponseBody> register(
            @RequestBody UserRegisterPostReq registerInfo) {

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
    public ResponseEntity<? extends BaseResponseBody> getUserInfo(@PathVariable String id, Authentication authentication) {

        TNTUserDetails userDetails = (TNTUserDetails) authentication.getDetails();
        User user = userService.getUserByUserId(id);

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

    @PostMapping("/find/id")
    public ResponseEntity<? extends BaseResponseBody> findUserId(@RequestBody UserFindIdPostReq userFindIdPostReq) {


        String userId = userService.getUserId(userFindIdPostReq.getUser_name(),userFindIdPostReq.getUser_email());
        if(userId.equals(null)){
            return ResponseEntity.status(401).body(UserFindIdPostRes.of(401,"존재하지 않는 아이디"));
        }else
            return ResponseEntity.status(200).body(UserFindIdPostRes.of(200,"Success",userId));
    }

    @PostMapping("/find/pwd")
    public ResponseEntity<? extends BaseResponseBody> findUserPwd(@RequestBody UserFindPwdPostReq userFindPwdPostReq) {
        // 아이디와 이메일이 db에 존재하는지 확인
        User user = userService.getUserByUserId(userFindPwdPostReq.getUser_id());
        if(user==null){
            return ResponseEntity.status(401).body(UserFindPwdPostRes.of(401,"존재하지 않는 유저"));
        }
        // 임시 비밀번호 발부
        String tempPassword=userService.getRandomPassword();
        // 이메일 만들기
        String result=mailService.sendPwdToken(userFindPwdPostReq,tempPassword);
        // 비밀번호 임시 비밀번호로 변경
        UserUpdatePutReq userUpdatePutReq=new UserUpdatePutReq();
        userUpdatePutReq.setUser_name(user.getName());
        userUpdatePutReq.setUser_pwd(tempPassword);
        User updatedUser=userService.updateUser(user.getUserId(),userUpdatePutReq);
        if(updatedUser==null) return ResponseEntity.status(403).body(UserFindPwdPostRes.of(403,"문제 발생"));

        if(result.equals("Success")){
            return ResponseEntity.status(200).body(UserFindPwdPostRes.of(200,"Success"));
        }else return ResponseEntity.status(403).body(UserFindPwdPostRes.of(403,"Fail"));
    }
}
