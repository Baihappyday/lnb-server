package com.example.lnb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor  //全参构造
@NoArgsConstructor  //无参构造
@Data //自动生成get和set方法
@TableName("Userinformation")  //指定数据库中的表
public class Userinformation {

    private String uusername;

    private String uage;

    private String usex;

    private String uaddress;

    private String uphone;

    private String ubloodtype;

    private String uhealthcondition;

}
