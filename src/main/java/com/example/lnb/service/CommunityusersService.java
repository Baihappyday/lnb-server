package com.example.lnb.service;

import com.example.lnb.entity.dto.Allusers_DTO;
import com.example.lnb.entity.Communityusers;
import com.example.lnb.mapper.CommunityusersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityusersService {

    @Autowired
    private CommunityusersMapper communityusersMapper;

    /**
     * 注册
     */
    public Allusers_DTO register(Communityusers communityusers) {
        Allusers_DTO result=new Allusers_DTO();
        result.setJudgeinfo(false);
        try {
            Communityusers userByName = communityusersMapper.findUsers(communityusers.getCusername());
            if(userByName!=null) {
                //如果查询到 说明存在
                result.setMsg("用户名已存在");
            } else {
                communityusersMapper.register(communityusers);
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
    public Allusers_DTO login(Communityusers communityusers){
        Allusers_DTO result=new Allusers_DTO();
        result.setJudgeinfo(false);
        try {
            Communityusers userTemp = communityusersMapper.login(communityusers);
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
    public Allusers_DTO chpassword(String cusername, String coldPassword, String cnewPassword) {
        Allusers_DTO result=new Allusers_DTO();
        result.setJudgeinfo(false);
        try {
            if(cnewPassword.equals(coldPassword)) {
                result.setMsg("新密码不能和旧密码相同");
            } else {
                Communityusers userTemp = communityusersMapper.login(new Communityusers(cusername,coldPassword));
                if(userTemp==null){
                    result.setMsg("用户名或密码错误");
                }else {
                    communityusersMapper.chpassword(cusername,cnewPassword);
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
