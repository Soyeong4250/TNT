package com.ssafy.tnt.api.service;

import com.ssafy.tnt.api.request.UserFindPwdPostReq;
import com.ssafy.tnt.common.util.MailUtil;

public interface MailService {
    public String sendPwdToken(UserFindPwdPostReq userFindPwdPostReq, String tempPassword);
}
