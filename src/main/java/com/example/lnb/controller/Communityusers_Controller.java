package com.example.lnb.controller;

import com.example.lnb.entity.dto.Allusers_DTO;
import com.example.lnb.entity.Communityusers;
import com.example.lnb.service.CommunityusersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Communityusers_Controller {

    @Autowired
    private CommunityusersService communityusersService;

    /**
     * 注册
     */
    @PostMapping("/register/communityusers")
    public Allusers_DTO register(@RequestBody Communityusers communityusers){
        return communityusersService.register(communityusers);
    }

    /**
     * 登录
     */
    @PostMapping("/login/communityusers")
    public Allusers_DTO login(@RequestBody Communityusers communityusers){
        return communityusersService.login(communityusers);
    }

    /**
     * 修改密码
     */
    @PostMapping("/chpassword/communityusers")
    public Allusers_DTO chpassword(@RequestParam("cusername") String cusername,
                                   @RequestParam("coldPassword") String coldPassword,
                                   @RequestParam("cnewPassword") String cnewPassword) {
        return communityusersService.chpassword(cusername, coldPassword, cnewPassword);
    }

}
