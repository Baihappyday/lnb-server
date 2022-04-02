package com.example.lnb.service;

import com.example.lnb.entity.Orders;
import com.example.lnb.mapper.OrderAllocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  //注入到springboot容器中
public class OrdersAllocationService {
    @Autowired
    private OrderAllocationMapper OrderAllocationMapper;

    /**
     *需要传入两个值：当前用户名，订单状态（对应编号）
     * @param username
     * @param ostate
     * @return 返回一个订单列表
     */
    public List userOrderList(String username, String ostate) {
        List<Orders> re = null;
        try {
            re = OrderAllocationMapper.userFindOrders(username, ostate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return re;
    }

    /**
     * 需要传入两个值：当前服务人员名，订单状态（对应编号）
     * @param wusername 服务人员名
     * @param ostate  订单状态
     * @return 返回一个订单列表
     */
    public List serOrderList(String wusername, String ostate) {
        List<Orders> an = null;
        try {
            an = OrderAllocationMapper.serFindOrders(wusername, ostate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return an;
    }

}
