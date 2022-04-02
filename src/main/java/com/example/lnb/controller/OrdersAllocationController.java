package com.example.lnb.controller;

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
     * @return 向前端返回一个List的数据类型
     */
    @PostMapping("/userOrderList")
    public List userOrderList(@RequestParam("username") String username, @RequestParam("ostate") String ostate){
        return OrdersAllocationService.userOrderList(username, ostate);
    }

    /**
     * 需要传入两个值：当前服务人员名，订单状态（对应编号）
     * @param wusername 服务人员名
     * @param ostate 订单状态
     * @return 向前端返回一个List的数据类型
     */
    @PostMapping("/serOrderList")
    public List serOrderList(@RequestParam("wusername") String wusername, @RequestParam("ostate") String ostate){
        return OrdersAllocationService.serOrderList(wusername, ostate);
    }


    /*返回的List类型数据，样例：
        {
            "username": "111",
            "wusername": "111",
            "otype": "0",
            "oduration": "1",
            "oscore": "2",
            "ostate": "1",
            "oprice": "3"
        }
     */



}
