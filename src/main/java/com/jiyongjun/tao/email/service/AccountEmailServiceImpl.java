package com.jiyongjun.tao.email.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.internet.MimeMessage;

/**
 * @author jiyongjun
 * @create 2018-05-06 14:03
 * @desc 账户邮件服务类
 **/
@Service("accountEmailService")
public class AccountEmailServiceImpl implements AccountEmailService {
    @Resource(name = "javaMailSender")
    private JavaMailSender javaMailSender;
    /**
     * 系统邮件地址
     **/
    @Value(value = "${email.systemEmail}")
    private String systemEmail;

    @Override
    public void sendMail(String to, String subject, String htmlText) throws Exception {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper msgHelper = new MimeMessageHelper(msg, "gbk");
        msgHelper.setFrom(systemEmail);
        msgHelper.setTo(to);
        msgHelper.setSubject(subject);
        msgHelper.setText(htmlText, true);
        javaMailSender.send(msg);
    }
}
