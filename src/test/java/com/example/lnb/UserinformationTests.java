package com.example.lnb;

import com.example.lnb.entity.Userinformation;
import org.junit.jupiter.api.Test;

public class UserinformationTests {
    @Test
    public void updateInfoByuusername() {
        Userinformation userinformation = new Userinformation();
        userinformation.setUusername("111");
        userinformation.setUphone("135231590166");
        userinformation.setUsex("男");
        userinformation.setUaddress("郑州");
    }

}
