package com.ssafy.tnt.api.request;

import lombok.Getter;
import lombok.Setter;

/**
 * [POST] /api/user/find/id
 * 유저 아이디 찾기 API Request Body 정의.
 */
@Getter
@Setter
public class UserFindIdPostReq {
    private String user_name;
    private String user_email;
}
