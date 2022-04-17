package com.example.lnb.service;

import com.example.lnb.entity.Users;
import com.example.lnb.entity.dto.Allusers_DTO;
import com.example.lnb.entity.dto.Users_DTO;
import com.example.lnb.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service  //注入到springboot容器中
public class UsersService {

    @Autowired
    private UsersMapper userMapper;

    /**
     * 注册
     */
    public Allusers_DTO register(Users users) {
        Allusers_DTO result=new Allusers_DTO();
        result.setJudgeinfo(false);
        try {
            Users userByName = userMapper.findUsers(users.getUsername());
            if(userByName!=null) {
                //如果查询到 说明存在
                result.setMsg("用户名已存在");
            } else {
                userMapper.register(users);
                result.setMsg("注册成功");
                result.setJudgeinfo(true);
            }
        } catch(Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 登录
     */
    public Users_DTO login(Users users){
        Users_DTO result=new Users_DTO();
        result.setJudgeinfo(false);
        try {
            Users userTemp = userMapper.login(users);
            if(userTemp==null){
                result.setMsg("用户名或密码错误");
            }else {
                result.setMsg("登录成功");
                result.setJudgeinfo(true);
                result.setAccount(userTemp.getAccount());
            }
        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 修改密码
     */
    public Allusers_DTO chpassword(String username, String oldPassword, String newPassword) {
        Allusers_DTO result=new Allusers_DTO();
        result.setJudgeinfo(false);
        try {
            if(newPassword.equals(oldPassword)) {
                result.setMsg("新密码不能和旧密码相同");
            } else {
                Users userTemp = userMapper.login(new Users(username,oldPassword,0));
                if(userTemp==null){
                    result.setMsg("用户名或密码错误");
                }else {
                    userMapper.chpassword(username,newPassword);
                    result.setMsg("密码更改成功");
                    result.setJudgeinfo(true);
                }
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}