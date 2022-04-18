package com.example.lnb.mapper;

import com.example.lnb.entity.Institutions;
import com.example.lnb.entity.Institutionusers;
import org.apache.ibatis.annotations.*;

@Mapper
public interface InstitutionusersMapper {

    /**
     *查看用户名是否已经存在
     */
    @Select("SELECT *  FROM Institutionusers where iusername=#{iusername}")
    Institutionusers findUsers(@Param("iusername") String iusername);

    /**
     * 注册
     */
    @Insert("INSERT INTO Institutionusers VALUES (#{iusername},#{ipassword})")
    @Options(useGeneratedKeys = true,keyProperty = "iusername",keyColumn = "iusername")
    void register(Institutionusers institutionusers);



    /**
     * 登录
     */
    @Select("SELECT *  FROM Institutionusers where iusername=#{iusername} and ipassword=#{ipassword}")
    Institutionusers login(Institutionusers institutionusers);

    /**
     * 修改密码
     */
    @Update("UPDATE Institutionusers SET ipassword=#{ipassword} WHERE iusername=#{iusername}")
    void chpassword(@Param("iusername")String iusername, @Param("ipassword") String inewPassword);

}
