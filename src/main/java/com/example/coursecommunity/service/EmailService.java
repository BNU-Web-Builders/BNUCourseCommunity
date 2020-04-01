package com.example.coursecommunity.service;

public interface EmailService {
    /**
     * 向新的用户发送验证邮件
     *
     * @param email
     * @param code
     * @return
     */
    boolean sendRegisterCode(String email, String code);
}
