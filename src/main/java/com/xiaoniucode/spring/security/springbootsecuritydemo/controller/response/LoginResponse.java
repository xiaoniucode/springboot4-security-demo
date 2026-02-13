package com.xiaoniucode.spring.security.springbootsecuritydemo.controller.response;

import lombok.Data;

@Data
public class LoginResponse {

    private String token;

    private String username;

}
