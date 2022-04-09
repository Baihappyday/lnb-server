package com.example.lnb.service;

import com.example.lnb.entity.Orders;
import com.example.lnb.entity.dto.Orders_DTO;
import com.example.lnb.mapper.OrderscoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderscoreService {
    @Autowired
    private OrderscoreMapper orderscoreMapper;
    public Orders_DTO score(Orders orders){
        Orders_DTO result = new Orders_DTO();
        try{
            result.setMsg("true");
            result.setOID(orders.getOID());
            result.setOscore(orders.getOscore());
            orderscoreMapper.updatebyOID(orders.getOID(), orders.getOscore());
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg("error");
        }
        return result;
    }
}
