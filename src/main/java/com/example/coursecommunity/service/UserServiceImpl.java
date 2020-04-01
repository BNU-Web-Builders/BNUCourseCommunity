package com.example.coursecommunity.service;

import com.example.coursecommunity.entity.User;
import com.example.coursecommunity.repository.UserRepository;
import com.example.coursecommunity.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;


    @Transactional
    @Override
    public User saveOrUpdateUser(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public boolean registerUser(User user) {

        String code = CodeUtil.generateUniqueCode();
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setState(false);
        user.setCode(code);
        //保存成功则通过线程的方式给用户发送一封邮件
        if (userRepository.save(user) != null) {
            emailService.sendRegisterCode(user.getAccount(), code);
            return true;
        }
        return false;
    }

    @Override
    public User activeUser(String account, String code) {
        Optional<User> user1 = userRepository.findByAccount(account);
        if (user1.isPresent()) {
            if (user1.get().getCode().equals(code)) {
                User user2 = user1.get();
                user2.setState(true);
                return userRepository.save(user2);
            } else return null;
        } else return null;
    }

    @Override
    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean checkAccountPresent(String account) {
        if (userRepository.findByAccount(account).isPresent())
            return true;
        else return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByAccount(username);
        if (user.isPresent()) {
            User user1 = user.get();
            if (user1.isState())
                return user.get();
            else
                return new User("fake", "fake", new BCryptPasswordEncoder().encode("fake"), "", null, false, "fake");
        } else
            return new User("fake", "fake", new BCryptPasswordEncoder().encode("fake"), "", null, false, "fake");
    }
}
