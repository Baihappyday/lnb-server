package com.example.lnb.mapper;

import com.example.lnb.entity.Users;
import org.apache.ibatis.annotations.*;


@Mapper//注入到springboot容器中
public interface LoginRegisterMapper {

    /**
     *查看用户名是否已经存在
     * @param username
     * @return
     */
    @Select("SELECT * FROM Users WHERE username=#{username}")
    Users findUsers(@Param("username") String username);




    /**
     * 注册
     * @param users
     */
    @Insert("INSERT INTO Users(username,password) VALUES (#{username},#{password})")
    @Options(useGeneratedKeys = true,keyProperty = "username",keyColumn = "username")
    void register(Users users);




    /**
     * 登录
     * @param users
     * @return
     */
    @Select("SELECT *  FROM Users where username=#{username} and password=#{password}")
    Users login(Users users);
}
