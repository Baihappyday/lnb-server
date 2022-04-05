package com.example.lnb.mapper;

import com.example.lnb.entity.Workers;
import org.apache.ibatis.annotations.*;

@Mapper
public interface WorkersMapper {

    /**
     *查看用户名是否已经存在
     */
    @Select("SELECT *  FROM Workers where wusername=#{wusername}")
    Workers findUsers(@Param("wusername") String wusername);

    /**
     * 注册
     */
    @Insert("INSERT INTO Workers VALUES (#{wusername},#{wpassword},'1000','100')")
    @Options(useGeneratedKeys = true,keyProperty = "wusername",keyColumn = "wusername")
    void register(Workers Workers);

    /**
     * 登录
     */
    @Select("SELECT *  FROM Workers WHERE wusername=#{wusername} AND wpassword=#{wpassword}")
    Workers login(Workers Workers);

    /**
     * 修改密码
     */
    @Update("UPDATE Workers SET wpassword=#{wpassword} WHERE wusername=#{wusername}")
    void chpassword(@Param("wusername")String wusername, @Param("wpassword") String wnewPassword);

}
