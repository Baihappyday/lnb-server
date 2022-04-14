package com.example.lnb.mapper;

import com.example.lnb.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OrderscoreMapper {

    @Select("select * from Orders WHERE OID=#{OID} and username=#{username} and ostate=2")
    Orders selectList(@Param("OID") Integer OID, @Param("username") String username);

    @Update("UPDATE Orders SET oscore=#{oscore} WHERE OID=#{OID} and username=#{username} and ostate=2")
    void orderScoreUpdate(@Param("OID") Integer OID, @Param("oscore") Integer oscore, @Param("username") String username);

    @Update("UPDATE Orders SET ostate=3 WHERE OID=#{OID} and username=#{username} and ostate=2")
    void orderstateUpdate(@Param("OID") Integer OID, @Param("username") String username);


}
