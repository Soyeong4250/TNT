package com.ssafy.tnt.api.service;

import com.ssafy.tnt.api.request.UserRegisterPostReq;
import com.ssafy.tnt.api.request.UserUpdatePutReq;
import com.ssafy.tnt.db.entity.User;

public interface UserService {
    User createUser(UserRegisterPostReq userRegisterInfo);
    User getUserByUserId(String userId);
    void deleteByUserId(String userId);
    User updateUser(String id, UserUpdatePutReq userUpdateInfo);
    String getUserId(String name, String email);
    String getRandomPassword();
}
