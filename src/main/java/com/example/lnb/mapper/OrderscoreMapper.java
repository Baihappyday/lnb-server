package com.example.lnb.mapper;

import com.example.lnb.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OrderscoreMapper {

    @Update("UPDATE Orders SET oscore=#{oscore} WHERE OID=#{OID}")
    void updatebyOID(@Param("OID") Integer OID, @Param("oscore") Integer oscore);


}
