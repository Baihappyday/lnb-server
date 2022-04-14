package com.example.lnb.service;

import com.example.lnb.entity.Orders;
import com.example.lnb.entity.dto.OrderScore_DTO;
import com.example.lnb.entity.dto.Orders_DTO;
import com.example.lnb.mapper.OrderscoreMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderscoreService {
    @Autowired
    private OrderscoreMapper orderscoreMapper;
    public OrderScore_DTO orderScore(Integer OID, String username, Integer oscore){
        OrderScore_DTO result = new OrderScore_DTO();
        try{
            Orders an = orderscoreMapper.selectList(OID, username);
            if(an != null) {
                result.setMsg("true");
                orderscoreMapper.orderScoreUpdate(OID, oscore, username);
                orderscoreMapper.orderstateUpdate(OID, username);
                result.setOID(an.getOID());
                result.setOscore(oscore);
            }
            else
                result.setMsg("error");
        }catch (Exception e){
            result.setMsg("error");
            e.printStackTrace();
        }finally {
            return result;
        }
    }
}
