package com.example.lnb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor  //全参构造
@NoArgsConstructor  //无参构造
@Data //自动生成get和set方法
@TableName("Workers")  //指定数据库中的表
public class Workers {

    private String wusername;

    private String wpassword;

    private int waccount;

    private int wscore;

}
