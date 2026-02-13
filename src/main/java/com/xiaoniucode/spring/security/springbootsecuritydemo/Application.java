package com.xiaoniucode.spring.security.springbootsecuritydemo;

import com.xiaoniucode.spring.security.springbootsecuritydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ApplicationRunner initData() {
        return args -> {
            // 初始化测试用户
            userService.initAdminUser();
            userService.initNormalUser();
        };
    }

}
