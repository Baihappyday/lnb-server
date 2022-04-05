package com.example.lnb.service;

import com.example.lnb.entity.dto.Allusers_DTO;
import com.example.lnb.entity.Institutionusers;
import com.example.lnb.mapper.InstitutionusersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitutionusersService {

    @Autowired
    private InstitutionusersMapper institutionusersMapper;

    /**
     * 注册
     */
    public Allusers_DTO register(Institutionusers institutionusers) {
        Allusers_DTO result=new Allusers_DTO();
        result.setJudgeinfo(false);
        try {
            Institutionusers userByName = institutionusersMapper.findUsers(institutionusers.getIusername());
            if(userByName!=null) {
                //如果查询到 说明存在
                result.setMsg("用户名已存在");
            } else {
                institutionusersMapper.register(institutionusers);
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
    public Allusers_DTO login(Institutionusers institutionusers){
        Allusers_DTO result=new Allusers_DTO();
        result.setJudgeinfo(false);
        try {
            Institutionusers userTemp = institutionusersMapper.login(institutionusers);
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
    public Allusers_DTO chpassword(String iusername, String ioldPassword, String inewPassword) {
        Allusers_DTO result=new Allusers_DTO();
        result.setJudgeinfo(false);
        try {
            if(inewPassword.equals(ioldPassword)) {
                result.setMsg("新密码不能和旧密码相同");
            } else {
                Institutionusers userTemp = institutionusersMapper.login(new Institutionusers(iusername,ioldPassword));
                if(userTemp==null){
                    result.setMsg("用户名或密码错误");
                }else {
                    institutionusersMapper.chpassword(iusername,inewPassword);
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
