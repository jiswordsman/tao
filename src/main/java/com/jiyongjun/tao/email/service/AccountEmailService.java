package com.jiyongjun.tao.email.service;

/**
 * @author jiyongjun
 * @create 2018-05-06 14:01
 * @desc 账户邮件服务接口
 **/
public interface AccountEmailService {
    /**
     * 发送html格式的邮件
     * @param to 接收地址
     * @param subject 邮件主题
     * @param htmlText 内容
     * @throws Exception
     */
    void sendMail(String to, String subject, String htmlText) throws Exception;
}
