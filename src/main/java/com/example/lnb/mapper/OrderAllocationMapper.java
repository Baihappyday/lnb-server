package com.example.lnb.mapper;

import com.example.lnb.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户个人中心根据订单状态放入对应的订单列表
 */
@Mapper
public interface OrderAllocationMapper {

    /**根据需要传入两个值查找：当前用户名，订单状态（对应编号）
     * 根据用户名和订单状态放入订单列表
     * @param username  用户名
     * @param ostate    订单状态
     * @return
     */
    @Select("SELECT * FROM Orders WHERE username=#{username} AND ostate=#{ostate}")
    List<Orders> userFindOrders(@Param("username") String username, @Param("ostate") String ostate);


    /**
     * 服务人员个人中心根据订单状态放入对应的订单列表
     * @param wusername 服务人员名
     * @param ostate  订单状态
     * @return
     */
    @Select("SELECT * FROM Orders WHERE wusername=#{wusername} AND ostate=#{ostate}")
    List<Orders> serFindOrders(@Param("wusername") String wusername, @Param("ostate") String ostate);

}
