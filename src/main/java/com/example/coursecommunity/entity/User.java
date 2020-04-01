package com.example.coursecommunity.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails, Serializable {
    private static final long serialVersionUID = 1L;

    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "昵称不能为空")
    @Size(min = 2, max = 16)
    @Column(nullable = false, length = 16)
    private String username;

    @NotEmpty(message = "学号不能为空")
    @Size(min = 2, max = 30)
    @Column(nullable = false, length = 30, unique = true)
    private String account;

    @NotEmpty(message = "密码不能为空")
    @Size(max = 100)
    @Column(length = 100)
    private String password;

    @Column(length = 200)
    private String avatar = "";

    private Long orgId;//外键连接Organization

    private boolean state;//用户是否被激活

    @Column(nullable = false)
    private String code;//'激活码'

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;


    public User() {
    }

    public User(@NotEmpty(message = "昵称不能为空") @Size(min = 2, max = 16) String username, @NotEmpty(message = "学号不能为空") @Size(min = 2, max = 30) String account, @NotEmpty(message = "密码不能为空") @Size(max = 100) String password, String avatar, Long orgId, boolean state, String code, List<Authority> authorities) {
        this.username = username;
        this.account = account;
        this.password = password;
        this.avatar = avatar;
        this.orgId = orgId;
        this.state = state;
        this.code = code;
        this.authorities = authorities;
    }

    public User(@NotEmpty(message = "昵称不能为空") @Size(min = 2, max = 16) String username, @NotEmpty(message = "学号不能为空") @Size(min = 2, max = 30) String account, @NotEmpty(message = "密码不能为空") @Size(max = 100) String password, String avatar, Long orgId, boolean state, String code) {
        this.username = username;
        this.account = account;
        this.password = password;
        this.avatar = avatar;
        this.orgId = orgId;
        this.state = state;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", orgId=" + orgId +
                ", state=" + state +
                ", code='" + code + '\'' +
                '}';
    }
}