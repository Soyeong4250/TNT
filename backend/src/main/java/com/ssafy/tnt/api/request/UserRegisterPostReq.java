package com.ssafy.tnt.api.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * [POST] /api/users/register
 * 유저 등록 API 요청에 대한 Response 값 정의.
 */
@Getter
@Setter
public class UserRegisterPostReq {
    private String user_name;
    private String user_id;
    private String user_email;
    private String user_pwd;
    private LocalDate user_birth;
    private String user_auth;
}
