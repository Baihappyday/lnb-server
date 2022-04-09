package com.example.lnb.service;

import com.example.lnb.entity.Orders;
import com.example.lnb.entity.dto.OrderFinish_DTO;
import com.example.lnb.mapper.OrderFinishMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderFinishService {
    @Autowired
    private OrderFinishMapper orderFinishMapper;

    public OrderFinish_DTO orderFinish(Integer OID, String username) {
        OrderFinish_DTO result = new OrderFinish_DTO();

        try{
            Orders an = orderFinishMapper.selectList(OID, username);
            if(an != null){
                result.setMsg("true");
                orderFinishMapper.orderFinish(OID, username);
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
