package com.example.lnb.mapper;

import com.example.lnb.entity.Userinformation;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserinformationMapper {

    /**
     * 展示个人信息
     * @param uusername
     * @return
     */
    @Select("SELECT uage,usex,uaddress,uphone,ubloodtype,uhealthcondition FROM Userinformation join Users where Userinformation.uusername=#{uusername} and Userinformation.uusername=Users.username")
    Userinformation findUserinformation(@Param("uusername") String uusername);


    /**
     * 修改个人信息
     * @param userinformation
     * @return
    */
    @Update("UPDATE Userinformation SET uage=#{uage},usex=#{usex},uaddress=#{uaddress},uphone=#{uphone} WHERE uusername=#{uusername}")
    void updateInfoByuusername(Userinformation userinformation);

    /**
     * 修改健康信息
     *
     */
    @Update("UPDATE Userinformation SET ubloodtype=#{ubloodtype},uhealthcondition=#{uhealthcondition} WHERE uusername=#{uusername}")
    void updateHealthByuusername(Userinformation userinformation);

}
