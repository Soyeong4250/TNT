package com.ssafy.tnt.api.request;

import lombok.Getter;
import lombok.Setter;

/**
 * [POST] /api/user/find/pwd
 * 유저 비밀번호 찾기 API Request Body 정의.
 */
@Getter
@Setter
public class UserFindPwdPostReq {
    private String user_id;
    private String user_email;
}
