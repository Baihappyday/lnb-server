package com.example.lnb.service;

import com.example.lnb.entity.Orders;
import com.example.lnb.mapper.OrdersworkerListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersworkerListServices {
    @Autowired
    private OrdersworkerListMapper OrdersworkerListMapper;

    public List workerOrderlist(String ostate){
        List<Orders> re=null;
        try{
            re = OrdersworkerListMapper.WorkerFindOrders(ostate);
        } catch(Exception e){
            e.printStackTrace();
        }
        return re;
    }
}
