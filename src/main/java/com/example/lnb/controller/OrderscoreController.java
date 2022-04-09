package com.example.lnb.controller;

import com.example.lnb.entity.Orders;
import com.example.lnb.entity.dto.Orders_DTO;
import com.example.lnb.service.OrderscoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderscoreController {
    @Autowired
    private OrderscoreService orderscoreService;

    @PostMapping("order-score")
    public Orders_DTO score(@RequestBody Orders orders)
    {
        return orderscoreService.score(orders);
    }
}
