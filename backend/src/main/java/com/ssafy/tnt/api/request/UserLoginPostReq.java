package com.ssafy.tnt.api.request;

import lombok.Getter;
import lombok.Setter;

/**
 * [POST] /api/auth/login
 * 유저 로그인 API Request Body 정의.
 */
@Getter
@Setter
public class UserLoginPostReq {
    String user_id;
    String user_pwd;
}