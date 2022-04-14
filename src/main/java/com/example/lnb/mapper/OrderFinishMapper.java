package com.example.lnb.mapper;

import com.example.lnb.entity.Orders;
import com.example.lnb.entity.dto.OrderFinish_DTO;
import com.example.lnb.entity.dto.Orders_DTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 订单完成后将状态改为2，由前端传入订单号和用户id
 */
@Mapper
public interface OrderFinishMapper {

    @Select("select * from Orders where OID = #{OID} and username = #{username} and ostate = 1")
    Orders selectList(@Param("OID") Integer OID, @Param("username") String username);

    @Select("select account from Users where username = #{username}")
    int UserMoney(@Param("username") String username);

    @Update("update Users set Users.account=Users.account-(select oprice from Orders where OID=#{OID} and username=#{username})" +
            "where Users.account>=(select oprice from Orders where OID=#{OID} and username=#{username}) and username=#{username} and Users.account>=0")
    void orderMoneyUser(@Param("OID") Integer OID, @Param("username") String username);

    @Update("update Workers set Workers.waccount=Workers.waccount+(select oprice from Orders where OID=#{OID} and wusername=#{wusername})" +
            "where Workers.waccount>=(select oprice from Orders where OID=#{OID} and wusername=#{wusername}) and wusername=#{wusername} and Workers.waccount>=0")
    void orderMoneyWorkers(@Param("OID") Integer OID, @Param("wusername") String wusername);


    @Update("update Orders set ostate = 2 where OID = #{OID} and username = #{username} and ostate = 1")
    void orderFinish(@Param("OID") Integer OID, @Param("username") String username);
}
