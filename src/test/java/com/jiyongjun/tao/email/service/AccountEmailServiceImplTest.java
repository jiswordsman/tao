package com.jiyongjun.tao.email.service;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.mail.internet.MimeMessage;

import static org.junit.Assert.*;

public class AccountEmailServiceImplTest {
    private GreenMail greenMail;

    @Before
    public void setUp() throws Exception {
        greenMail = new GreenMail(ServerSetup.SMTP);
        greenMail.setUser("test","123456");
        greenMail.start();
    }

    @After
    public void tearDown() throws Exception {
        greenMail.stop();
    }

    @Test
    public void sendMail() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountEmailService emailService = (AccountEmailService) context.getBean("accountEmailService");
        String subject = "媳妇儿亲启";
        String htmlText = "<meta http-equiv='content-type' content='text/html; charset=GBK'> \n <h3>媳妇儿，爱你呦，咱们可以出去玩了</h3>\n" +
                "<img src=\"https://jiyongjun.oss-cn-qingdao.aliyuncs.com/%E4%B8%AA%E4%BA%BA/%E5%AA%B3%E5%A6%87%E5%84%BF.png\">\n" +
                "<img src=\"https://jiyongjun.oss-cn-qingdao.aliyuncs.com/%E4%B8%AA%E4%BA%BA/%E5%AA%B3%E5%A6%87%E5%84%BF2.png\">\n";
        emailService.sendMail("jiswordsman@163.com", subject, htmlText);
        emailService.sendMail("jiyongjun09@163.com", subject, htmlText);
        emailService.sendMail("785374703@qq.com", subject, htmlText);
        /*greenMail.waitForIncomingEmail(5000, 1);
        MimeMessage[] msgs = greenMail.getReceivedMessages();
        assertEquals(1, msgs.length);
        assertEquals(subject, msgs[0].getSubject());
        assertEquals(htmlText, GreenMailUtil.getBody(msgs[0]).trim());*/
    }
}