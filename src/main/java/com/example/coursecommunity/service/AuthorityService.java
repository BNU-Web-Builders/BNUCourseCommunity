package com.example.coursecommunity.service;

import com.example.coursecommunity.entity.Authority;

import java.util.Optional;

public interface AuthorityService {
    /**
     * 根据ID查询角色
     *
     * @param id
     * @return
     */
    Optional<Authority> getAuthorityById(Long id);
}
