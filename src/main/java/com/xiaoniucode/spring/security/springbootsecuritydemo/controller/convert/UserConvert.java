package com.xiaoniucode.spring.security.springbootsecuritydemo.controller.convert;

import com.xiaoniucode.spring.security.springbootsecuritydemo.controller.request.RegisterRequest;
import com.xiaoniucode.spring.security.springbootsecuritydemo.controller.response.LoginResponse;
import com.xiaoniucode.spring.security.springbootsecuritydemo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConvert {

    @Mapping(target = "password", ignore = true)
    User registerRequestToUser(RegisterRequest request);

    LoginResponse createLoginResponse(String token, String username);

}
