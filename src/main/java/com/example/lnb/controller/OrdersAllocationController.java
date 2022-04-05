package com.example.lnb.controller;

import com.example.lnb.entity.dto.Orders_DTO;
import com.example.lnb.service.OrdersAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdersAllocationController {

    @Autowired
    private OrdersAllocationService OrdersAllocationService;

    /**
     * 需要传入两个值：当前用户名，订单状态（对应编号）
     * @param username
     * @param ostate
     * @return
     */
    @PostMapping("/userOrderList")
    public List userOrderList(@RequestParam("username") String username, @RequestParam("ostate") String ostate){
        return OrdersAllocationService.userOrderList(username, ostate);
    }

    /**
     * 需要传入两个值：当前服务人员名，订单状态（对应编号）
     * @param wusername 服务人员名
     * @param ostate 订单状态
     * @return
     */
    @PostMapping("/serOrderList")
    public List serOrderList(@RequestParam("wusername") String wusername, @RequestParam("ostate") String ostate){
        return OrdersAllocationService.serOrderList(wusername, ostate);
    }



}
