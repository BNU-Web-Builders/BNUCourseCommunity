package com.example.coursecommunity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("userServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    private static final String KEY = "course.com";

    /**
     * 自定义配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/fonts/**", "/register", "/active", "/checkAccount").permitAll()  // 虽都可以访问
                .antMatchers("/users/**", "/index").hasRole("USER")   // 需要相应的角色才能访问
                .antMatchers("/admins/**").hasRole("ADMIN")   // 需要相应的角色才能访问
                .and()
                .formLogin()   //基于 Form 表单登录验证
                .loginPage("/login").failureUrl("/login-error")  // 自定义登录界面
                .and().rememberMe().key(KEY); // 启用 remember me;
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login");
    }

    /**
     * 认证信息管理
     *
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        try {
            auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
        } catch (InternalAuthenticationServiceException e) {
            System.out.println("error!");
        }

    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}