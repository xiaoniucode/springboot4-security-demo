package com.xiaoniucode.spring.security.springbootsecuritydemo.controller;

import com.xiaoniucode.spring.security.springbootsecuritydemo.common.Ajax;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/public")
    public Ajax getPublicApi() {
        return Ajax.success("这是公开接口，无需认证");
    }

    @GetMapping("/protected")
    public Ajax getProtectedApi(Authentication authentication) {
        String username = authentication.getName();
        return Ajax.success("这是需要认证的接口", "欢迎 " + username + "，您已成功认证");
    }

}
