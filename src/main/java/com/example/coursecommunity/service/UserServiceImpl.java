package com.example.coursecommunity.service;

import com.example.coursecommunity.entity.User;
import com.example.coursecommunity.repository.UserRepository;
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
    public User registerUser(User user) {
        return userRepository.save(user);
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
