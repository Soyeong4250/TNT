package com.ssafy.tnt.api.response;

import com.ssafy.tnt.common.model.response.BaseResponseBody;
import lombok.Getter;
import lombok.Setter;

/**
 * [POST] /api/auth/login
 * 유저 로그인 API 요청에 대한 Response 값 정의.
 */
@Getter
@Setter
public class UserLoginPostRes extends BaseResponseBody {
    String accessToken;

    public static UserLoginPostRes of(Integer statusCode, String message, String accessToken) {
        UserLoginPostRes res = new UserLoginPostRes();
        res.setStatusCode(statusCode);
        res.setMessage(message);
        res.setAccessToken(accessToken);
        return res;
    }
}
