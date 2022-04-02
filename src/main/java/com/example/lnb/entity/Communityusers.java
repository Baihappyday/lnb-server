package com.example.lnb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor  //全参构造
@NoArgsConstructor  //无参构造
@Data
@TableName("Communityusers")
public class Communityusers {
    private String cusername;
    private String cpassword;
}
