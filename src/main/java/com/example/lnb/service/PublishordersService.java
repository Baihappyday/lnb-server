package com.example.lnb.service;

import com.example.lnb.entity.Orders;
import com.example.lnb.entity.dto.Orders_DTO;
import com.example.lnb.mapper.PublishordersMapper;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishordersService {
    @Autowired
    private PublishordersMapper publishordersMapper;
    public Orders_DTO publishorders(Orders orders){
        Orders_DTO result = new Orders_DTO();
        try{
            result.setMsg("true");
            result.setUsername(orders.getUsername());
            result.setOtype(orders.getOtype());
            result.setOduration(orders.getOduration());
            result.setOdescription(orders.getOdescription());
            result.setOprice(orders.getOprice());
            publishordersMapper.insertorder(orders);
        }catch(Exception e){
            e.printStackTrace();
            result.setMsg("error");
        }
        return result;
    }

}
