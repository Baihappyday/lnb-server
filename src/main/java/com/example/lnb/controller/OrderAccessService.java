package com.example.lnb.service;

import com.example.lnb.entity.Orders;
import com.example.lnb.entity.dto.Orders_DTO;
import com.example.lnb.mapper.OrderAccessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderAccessService {
    @Autowired
    private OrderAccessMapper OrderAccessMapper;

    public Orders_DTO Access(Orders Orders){
        Orders_DTO result =new Orders_DTO();
        try {
            Orders accessOrder = OrderAccessMapper.selectorders(Orders.getOID());
            String orderstate = accessOrder.getOstate();
            if (accessOrder != null) {
                    OrderAccessMapper.AccessOrders(Orders,Orders.getOID());
                    result.setMsg("获取任务成功");


            } else {
                result.setMsg("404，任务消失啦！");
            }

        }catch (Exception e){
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
