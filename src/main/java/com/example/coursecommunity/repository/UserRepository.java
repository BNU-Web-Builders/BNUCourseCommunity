package com.example.coursecommunity.repository;

import com.example.coursecommunity.entity.Organization;
import com.example.coursecommunity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 根据学号返回User（学号唯一）
     *
     * @param account
     * @return
     */
    Optional<User> findByAccount(String account);
}
