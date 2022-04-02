package com.example.lnb.controller;

import com.example.lnb.entity.Orders;
import com.example.lnb.entity.Userinformation;
import com.example.lnb.entity.dto.Display_Update_DTO;
import com.example.lnb.entity.dto.Orders_DTO;
import com.example.lnb.service.PublishordersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishordersController {
    @Autowired
    private PublishordersService publishordersService;

    @PostMapping("/publish-order")
    public Orders_DTO publishorder(@RequestBody Orders orders){
        return publishordersService.publishorders(orders);
    }
}
