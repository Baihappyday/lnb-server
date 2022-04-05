package com.example.lnb.mapper;

import com.example.lnb.entity.Communityusers;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CommunityusersMapper {

    /**
     *查看用户名是否已经存在
     */
    @Select("SELECT *  FROM Communityusers where cusername=#{cusername}")
    Communityusers findUsers(@Param("cusername") String cusername);

    /**
     * 注册
     */
    @Insert("INSERT INTO Communityusers VALUES (#{cusername},#{cpassword})")
    @Options(useGeneratedKeys = true,keyProperty = "cusername",keyColumn = "cusername")
    void register(Communityusers communityusers);

    /**
     * 登录
     */
    @Select("SELECT *  FROM Communityusers where cusername=#{cusername} and cpassword=#{cpassword}")
    Communityusers login(Communityusers communityusers);

    /**
     * 修改密码
     */
    @Update("UPDATE Communityusers SET cpassword=#{cpassword} WHERE cusername=#{cusername}")
    void chpassword(@Param("cusername")String cusername, @Param("cpassword") String cnewPassword);

}
