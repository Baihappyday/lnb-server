package com.example.lnb.controller;

import com.example.lnb.entity.Orders;
import com.example.lnb.entity.dto.OrderScore_DTO;
import com.example.lnb.entity.dto.Orders_DTO;
import com.example.lnb.service.OrderscoreService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderscoreController {
    @Autowired
    private OrderscoreService orderscoreService;

    /**
     * 订单评分并更新订单状态
     * @param OID 订单ID
     * @param username 用户名
     * @param oscore 订单评分
     * @return 返回是否成功msg，OID，订单评分
     */
    @PostMapping("/orderScore")
    public OrderScore_DTO score(@RequestParam("OID") Integer OID, @RequestParam("username") String username, @RequestParam("oscore") Integer oscore) {
        return orderscoreService.orderScore(OID, username, oscore);
    }
}
