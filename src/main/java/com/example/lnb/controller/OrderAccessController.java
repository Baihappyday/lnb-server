package com.example.lnb.controller;

import com.example.lnb.entity.Orders;
import com.example.lnb.entity.dto.Orders_DTO;
import com.example.lnb.service.OrderAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderAccessController {
    @Autowired
    private com.example.lnb.service.OrderAccessService OrderAccessService;

    @PostMapping("/AccessOrder")
    public @ResponseBody Orders_DTO register( Orders orders){
        return OrderAccessService.Access(orders);
    }
}
