package com.example.coursecommunity.service;

import com.example.coursecommunity.entity.User;
import com.example.coursecommunity.repository.UserRepository;
import com.example.coursecommunity.util.CodeUtil;
import com.example.coursecommunity.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(User user) {
        Optional<User> user1=userRepository.findByAccount(user.getAccount());
        if (user1.isPresent()){
            if(user1.get().getPassword().equals(user.getPassword())){
                return user1.get();
            }else return null;
        }else return null;
    }

    @Transactional
    @Override
    public User saveOrUpdateUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public boolean registerUser(User user) {

        String code= CodeUtil.generateUniqueCode();
        user.setState(false);
        user.setCode(code);
        //保存成功则通过线程的方式给用户发送一封邮件
        if(userRepository.save(user)!=null){
            String email=user.getAccount()+"@mail.bnu.edu.cn";
            new Thread(new MailUtil(email, code)).start();;
            return true;
        }
        return false;
    }

    @Override
    public User activeUser(User user) {
        Optional<User> user1=userRepository.findByAccount(user.getAccount());
        if(user1.isPresent()){
            if(user1.get().getCode().equals(user.getCode())){
                User user2=user1.get();
                user2.setState(true);
                return userRepository.save(user2);
            }
            else return null;
        }
        else return null;
    }

    @Override
    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}
