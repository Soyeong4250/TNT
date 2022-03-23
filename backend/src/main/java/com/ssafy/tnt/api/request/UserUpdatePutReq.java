package com.ssafy.tnt.api.request;

import lombok.Getter;
import lombok.Setter;
/**
 * [PUT] /api/users/{userId}
 * 유저 수정 API 요청에 대한 Response 값 정의.
 */
@Getter
@Setter
public class UserUpdatePutReq {
    private String user_name;
    private String user_pwd;
}
