package com.xiaoniucode.spring.security.springbootsecuritydemo.service;

import com.xiaoniucode.spring.security.springbootsecuritydemo.controller.request.RegisterRequest;

public interface UserService {

    boolean existsByUsername(String username);

    void register(RegisterRequest request);

    void initAdminUser();

    void initNormalUser();

}
