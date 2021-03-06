package com.example.lnb.mapper;

import com.example.lnb.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface OrderAccessMapper {
/**
 * 找出目标任务
 */
    @Select("SELECT * FROM Orders WHERE OID=#{OID} AND ostate=0")
    Orders selectorders(@Param("OID") Integer OID);
/**
 * 更新目标任务状态
 */

    @Update("UPDATE Orders SET ostate=1, wusername=#{wusername} WHERE OID=#{OID}")
    void  AccessOrders(@Param("wusername") String wusername,@Param("OID") Integer oid);

}
