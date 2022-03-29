package com.ssafy.tnt.api.service;

import com.ssafy.tnt.api.request.UserFindPwdPostReq;
import com.ssafy.tnt.common.util.MailUtil;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;

@Service
@AllArgsConstructor
public class MailServiceImpl implements MailService{
    JavaMailSender javaMailSender;
    SpringTemplateEngine springTemplateEngine;
    private static final String FROM_ADDRESS = "noreply@tnt.com";
    private static final String SUBJECT_NAME = "[TNT] 임시 비밀번호 확인";

    @Override
    public String sendPwdToken(UserFindPwdPostReq userFindPwdPostReq, String tempPassword) {
        Context context=new Context();
        try {
            MailUtil mailUtil = new MailUtil(javaMailSender);
            // 받는 사람
            mailUtil.setTo(userFindPwdPostReq.getUser_email());
            // 보내는 사람
            mailUtil.setFrom(MailServiceImpl.FROM_ADDRESS);
            // 제목
            mailUtil.setSubject(MailServiceImpl.SUBJECT_NAME);
            context.setVariable("name",userFindPwdPostReq.getUser_id());
            context.setVariable("pwd",tempPassword);
            // 내용
            mailUtil.setText(springTemplateEngine.process("Pwd-Find.html",context),true);

            mailUtil.send();
        }catch (MessagingException me){
            me.printStackTrace();
            return "Fail";
        }
        return "Success";
    }
}
