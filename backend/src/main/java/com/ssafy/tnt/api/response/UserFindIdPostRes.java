package com.ssafy.tnt.api.response;

import com.ssafy.tnt.common.model.response.BaseResponseBody;
import lombok.Getter;
import lombok.Setter;

/**
 * [POST] /api/users/find/id
 * 유저 아이디 찾기 API 요청에 대한 Response 값 정의.
 */
@Getter
@Setter
public class UserFindIdPostRes extends BaseResponseBody {
    String userId;

    public static UserFindIdPostRes of(Integer statusCode, String message, String userId){
        UserFindIdPostRes res = new UserFindIdPostRes();
        res.setStatusCode(statusCode);
        res.setMessage(message);
        res.setUserId(userId);
        return res;
    }
}
