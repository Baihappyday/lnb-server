package com.example.lnb.mapper;

import com.example.lnb.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;


/*
* 服务人员获取可接取订单列表
*/
@Mapper
public interface OrdersworkerListMapper {

    /**
     * 挑选订单界面根据订单状态放入对应的订单列表
     * @param ostate  订单状态
     * @return
     */
    @Select("SELECT * FROM Orders WHERE ostate=#{ostate}")
    List<Orders> WorkerFindOrders(@Param("ostate") String ostate );
}
