package com.example.lnb.controller;

import com.example.lnb.service.OrdersworkerListServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrdersworkerListController {
    @Autowired
    private OrdersworkerListServices OrdersworkerListServices;
    @PostMapping("/never gonna give you up")
    public List userOrderList(@RequestParam("ostate") String ostate){
        return OrdersworkerListServices.workerOrderlist(ostate);
    }
}
