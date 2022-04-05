package com.example.lnb.mapper;

import com.example.lnb.entity.Users;
import org.apache.ibatis.annotations.*;


@Mapper//注入到springboot容器中
public interface UsersMapper {

    /**
     *查看用户名是否已经存在
     */
    @Select("SELECT *  FROM Users where username=#{username}")
    Users findUsers(@Param("username") String username);

    /**
     * 注册
     */
    @Insert("INSERT INTO Users VALUES (#{username},#{password},'1000')")
    @Options(useGeneratedKeys = true,keyProperty = "username",keyColumn = "username")
    void register(Users users);

    /**
     * 登录
     */
    @Select("SELECT *  FROM Users where username=#{username} and password=#{password}")
    Users login(Users users);

    /**
     * 修改密码
     */
    @Update("UPDATE Users SET password=#{password} WHERE username=#{username}")
    void chpassword(@Param("username")String username, @Param("password") String newPassword);

}
