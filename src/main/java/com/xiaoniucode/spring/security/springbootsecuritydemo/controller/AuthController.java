package com.xiaoniucode.spring.security.springbootsecuritydemo.controller;

import com.xiaoniucode.spring.security.springbootsecuritydemo.common.Ajax;
import com.xiaoniucode.spring.security.springbootsecuritydemo.controller.convert.UserConvert;
import com.xiaoniucode.spring.security.springbootsecuritydemo.controller.request.LoginRequest;
import com.xiaoniucode.spring.security.springbootsecuritydemo.controller.request.RegisterRequest;
import com.xiaoniucode.spring.security.springbootsecuritydemo.service.UserService;
import com.xiaoniucode.spring.security.springbootsecuritydemo.util.TokenUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private UserConvert userConvert;

    @PostMapping("/login")
    public Ajax login(@Valid @RequestBody LoginRequest request) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = tokenUtil.generateToken(request.getUsername());
            return Ajax.success("登录成功", userConvert.createLoginResponse(token, request.getUsername()));
        } catch (Exception e) {
            return Ajax.error("用户名或密码错误");
        }
    }

    @PostMapping("/register")
    public Ajax register(@Valid @RequestBody RegisterRequest request) {
        try {
            userService.register(request);
            return Ajax.success("注册成功");
        } catch (Exception e) {
            return Ajax.error("注册失败: " + e.getMessage());
        }
    }

}
