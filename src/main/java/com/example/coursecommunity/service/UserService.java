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
    User registerUser(User user);

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
}
