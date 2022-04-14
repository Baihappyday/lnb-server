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
            int money = orderFinishMapper.UserMoney(username);
            if(an != null){
                if(money >= an.getOprice() && money >= 0) {
                    orderFinishMapper.orderMoneyUser(OID, username);
                    orderFinishMapper.orderMoneyWorkers(OID, an.getWusername());
                    orderFinishMapper.orderFinish(OID, username);
                    result.setMsg("支付成功，订单完成！");
                }
                else
                    result.setMsg("余额不足，请充值！");
            }
            else
                result.setMsg("订单不存在，请刷新！");
        }catch (Exception e){
            result.setMsg("订单错误！");
            e.printStackTrace();
        }finally {
            return result;
        }
    }

}
