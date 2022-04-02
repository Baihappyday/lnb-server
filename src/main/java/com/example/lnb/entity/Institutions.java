package com.example.lnb.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("Institutions")
public class Institutions {

    private String iiusername;
    private String iaddress;
    private String iname;
    private Integer iprice;
    private String idescription;
}
