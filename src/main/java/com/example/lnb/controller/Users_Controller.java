package com.example.lnb.controller;

import com.example.lnb.entity.Users;
import com.example.lnb.entity.dto.Allusers_DTO;
import com.example.lnb.entity.dto.Users_DTO;
import com.example.lnb.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class Users_Controller {

    @Autowired
    private UsersService usersService;

    /**
     * 注册
     */
    @PostMapping("/register/users")
    public Allusers_DTO register(@RequestBody Users users){
        return usersService.register(users);
    }

    /**
     * 登录
     */
    @PostMapping("/login/users")
    public Users_DTO login(@RequestBody Users users){
        return usersService.login(users);
    }

    /**
     * 修改密码
     */
    @PostMapping("/chpassword/users")
    public Allusers_DTO chpassword(@RequestParam("username") String username,
                                   @RequestParam("oldPassword") String oldPassword,
                                   @RequestParam("newPassword") String newPassword) {
        return usersService.chpassword(username, oldPassword, newPassword);
    }

}
