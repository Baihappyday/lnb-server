package com.example.lnb.service;

import com.example.lnb.entity.dto.Allusers_DTO;
import com.example.lnb.entity.Workers;
import com.example.lnb.mapper.WorkersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkersService {

    @Autowired
    private WorkersMapper workersMapper;

    /**
     * 注册
     */
    public Allusers_DTO register(Workers workers) {
        Allusers_DTO result=new Allusers_DTO();
        result.setJudgeinfo(false);
        try {
            Workers userByName = workersMapper.findUsers(workers.getWusername());
            if(userByName!=null) {
                //如果查询到 说明存在
                result.setMsg("用户名已存在");
            } else {
                workersMapper.register(workers);
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
    public Allusers_DTO login(Workers workers){
        Allusers_DTO result=new Allusers_DTO();
        result.setJudgeinfo(false);
        try {
            Workers userTemp = workersMapper.login(workers);
            if(userTemp==null){
                result.setMsg("用户名或密码错误");
            }else {
                result.setMsg("登录成功");
                result.setJudgeinfo(true);
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
    public Allusers_DTO chpassword(String wusername, String woldPassword, String wnewPassword) {
        Allusers_DTO result=new Allusers_DTO();
        result.setJudgeinfo(false);
        try {
            if(wnewPassword.equals(woldPassword)) {
                result.setMsg("新密码不能和旧密码相同");
            } else {
                Workers userTemp = workersMapper.login(new Workers(wusername,woldPassword,0,0));
                if(userTemp==null){
                    result.setMsg("用户名或密码错误");
                }else {
                    workersMapper.chpassword(wusername,wnewPassword);
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
