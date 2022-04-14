package com.example.lnb.controller;

import com.example.lnb.entity.dto.OrderFinish_DTO;
import com.example.lnb.service.OrderFinishService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderFinishController {

    @Autowired
    private OrderFinishService orderFinishService;

    /**
     * 订单完成
     * @param OID 订单ID
     * @param username 用户名
     * @return msg：订单是否完成
     */
    @PostMapping("/orderFinish")
    public OrderFinish_DTO orderFinish(@RequestParam("OID") Integer OID, @RequestParam("username") String username){
        return orderFinishService.orderFinish(OID,username);
    }

}

