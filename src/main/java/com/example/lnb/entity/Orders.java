package com.example.lnb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("Orders")
public class Orders {
    Integer OID;
    String username;
    String wusername;
    String otype;
    String oduration;
    String oscore;
    String ostate;
    Integer oprice;
    String odescription;
}
