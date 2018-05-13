package com.bgs.mylove.documentserver.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "user-server")
public interface UserServerFeign {

    @GetMapping("/user/login")
    public String login();
}
