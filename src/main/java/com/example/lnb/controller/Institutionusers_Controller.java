package com.example.lnb.controller;

import com.example.lnb.entity.dto.Allusers_DTO;
import com.example.lnb.entity.Institutionusers;
import com.example.lnb.service.InstitutionusersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Institutionusers_Controller {

    @Autowired
    private InstitutionusersService institutionusersService;

    /**
     * 注册
     */
    @PostMapping("/register/institutionusers")
    public Allusers_DTO register(@RequestBody Institutionusers institutionusers){
        return institutionusersService.register(institutionusers);
    }

    /**
     * 登录
     */
    @PostMapping("/login/institutionusers")
    public Allusers_DTO login(@RequestBody Institutionusers institutionusers){
        return institutionusersService.login(institutionusers);
    }

    /**
     * 修改密码
     */
    @PostMapping("/chpassword/institutionusers")
    public Allusers_DTO chpassword(@RequestParam("iusername") String iusername,
                                   @RequestParam("ioldPassword") String ioldPassword,
                                   @RequestParam("inewPassword") String inewPassword) {
        return institutionusersService.chpassword(iusername, ioldPassword, inewPassword);
    }

}
