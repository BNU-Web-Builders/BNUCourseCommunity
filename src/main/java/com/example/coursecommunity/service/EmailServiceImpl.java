package com.example.coursecommunity.service;

import com.example.coursecommunity.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSenderImpl mailSender;

    @Override
    public boolean sendRegisterCode(String account, String code) {
        String email = account + "@mail.bnu.edu.cn";
        Properties p = new Properties();
        p.put("userName", "bnucoursecommunity@163.com");
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            mimeMessage.addRecipients(MimeMessage.RecipientType.CC, InternetAddress.parse(p.getProperty("userName")));
            MimeMessageHelper helper = null;
            helper = new MimeMessageHelper(mimeMessage, true);
            helper.setSubject("激活邮件");
            helper.setText("<h1>这是一封激活邮件,激活请点击以下链接</h1><h3><a href='http://localhost:8080/active?account="
                    + account
                    + "&code="
                    + code
                    + "'>http://localhost:8080/active?account=" + account + "&code="
                    + code
                    + "</href></h3>", true);
            //收件人
            helper.setTo(email);
            //发送人
            helper.setFrom("bnucoursecommunity@163.com");
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        mailSender.send(mimeMessage);
        return true;
    }
}
