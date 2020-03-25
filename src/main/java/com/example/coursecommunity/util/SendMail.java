package com.example.coursecommunity.util;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by huangzhenyang on 2017/8/15.
 */
public class SendMail {
    // Spring的邮件工具类，实现了MailSender和JavaMailSender接口
    private JavaMailSenderImpl mailSender;
    private Properties p;
    private int timeout = 25000;
    private String subject = "账号激活";
    private StringBuilder content;
    private String code="";

    public SendMail(){
        mailSender = new JavaMailSenderImpl();
        p = new Properties();
        content = new StringBuilder();
        initMail(mailSender,p);
    }

    private void initMail(JavaMailSenderImpl mailSender, Properties p){
        String code="";
        // 设置参数
        mailSender.setHost("smtp.163.com");
        mailSender.setUsername("bnucoursecommunity@163.com"); //你的邮箱
        mailSender.setPassword("GEPEVQMIDVEUKOWS"); //密码，这里必须先在网易邮箱里开启smtp服务
        //设置property
        p.put("userName","bnucoursecommunity@163.com");
        p.setProperty("mail.smtp.timeout",timeout+"");
        p.setProperty("mail.smtp.auth","true");
        mailSender.setJavaMailProperties(p);

    }

    /**
     *
     * @param recipient 收件人
     *
     *
     */

    public void send(String recipient,String ycode) throws MessagingException {
        code=ycode;
        //设置内容格式
        content.append("<body>");
        content.append("<h1>这是一封激活邮件,激活请点击以下链接</h1><h3><a href='http://localhost:8080/RegisterDemo/ActiveServlet?code="
                + code
                + "'>http://localhost:8080/RegisterDemo/ActiveServlet?code="
                + code
                +"</href></h3>");
        content.append("</body>");
        // 构建简单邮件对象，见名知意
        MimeMessage msg = mailSender.createMimeMessage();
        // *** 关键 ***
        msg.addRecipients(MimeMessage.RecipientType.CC, InternetAddress.parse(p.getProperty("userName")));
        MimeMessageHelper helper = new MimeMessageHelper(msg,true,"utf-8");
        // 设定邮件参数
        helper.setFrom(mailSender.getUsername());
        helper.setTo(recipient);
        helper.setSubject(subject);
        helper.setText(content.toString(),true);
        System.out.println(">>> content:  "+content);
        // 发送邮件
        mailSender.send(msg);
    }

}