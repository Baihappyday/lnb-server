package com.example.lnb.controller;

import com.example.lnb.entity.dto.Allusers_DTO;
import com.example.lnb.entity.Workers;
import com.example.lnb.service.WorkersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Workers_Controller {

    @Autowired
    private WorkersService workersService;

    /**
     * 注册
     */
    @PostMapping("/register/workers")
    public Allusers_DTO register(@RequestBody Workers workers){
        return workersService.register(workers);
    }

    /**
     * 登录
     */
    @PostMapping("/login/workers")
    public Allusers_DTO login(@RequestBody Workers workers){
        return workersService.login(workers);
    }

    /**
     * 修改密码
     */
    @PostMapping("/chpassword/workers")
    public Allusers_DTO chpassword(@RequestParam("wusername") String wusername,
                                   @RequestParam("woldPassword") String woldPassword,
                                   @RequestParam("wnewPassword") String wnewPassword) {
        return workersService.chpassword(wusername, woldPassword, wnewPassword);
    }

}
