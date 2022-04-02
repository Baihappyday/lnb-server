package com.example.lnb.mapper;

import com.example.lnb.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PublishordersMapper {
/**
    @Select("Select * from Users join Orders where Users.username=Orders.username and Orders.username=#{username}")
    Orders findorderbyusername(@Param("username") String username);
*/
    @Insert("Insert into Orders(username,otype,oduration,odescription,oprice) values (#{username},#{otype},#{oduration},#{odescription},#{oprice})")
    void insertorder(Orders orders);

}

