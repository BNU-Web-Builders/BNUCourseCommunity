package com.example.coursecommunity.service;

import com.example.coursecommunity.entity.User;

import java.util.Optional;

public interface UserService {
    /**
     * 用户登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 新增、编辑、保存用户
     * @param user
     * @return
     */
    User saveOrUpdateUser(User user);

    /**
     * 注册用户
     * @param user
     * @return
     */
    boolean registerUser(User user);

    /**
     * 激活账号
     * @return
     */
    User activeUser(String account,String code);

    /**
     * 删除用户
     * @param id
     */
    void removeUser(Long id);

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    Optional<User> getUserById(Long id);

    /**
     * 查看账号是否已被注册
     * @param account
     * @return
     */
    boolean checkAccountPresent(String account);
}
