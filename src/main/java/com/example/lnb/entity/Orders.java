package com.example.lnb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor  //全参构造
@NoArgsConstructor  //无参构造
@Data //自动生成get和set方法
@TableName("Orders")  //指定数据库中的表
public class Orders {
    private Integer OID;
    private String username;  //用户名
    private String wusername;  //服务人员名
    private String otype;  //订单类型
    private String oduration;  //持续时间
    private Integer oscore;  //评分
    private String ostate;  //订单状态
    private Integer oprice;
    private String odescription;
}