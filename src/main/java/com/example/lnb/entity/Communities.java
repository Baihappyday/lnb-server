package com.example.lnb.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor  //全参构造
@NoArgsConstructor  //无参构造
@Data
@TableName("Communities")
public class Communities {
    private String ccusername;
    private String caddress;
    private String cname;
    private String cdescription;
}
