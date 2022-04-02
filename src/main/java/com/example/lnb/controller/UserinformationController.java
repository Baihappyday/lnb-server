package com.example.lnb.controller;

import com.example.lnb.entity.Userinformation;
import com.example.lnb.entity.dto.Display_Update_DTO;
import com.example.lnb.service.UserinformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserinformationController {
    @Autowired
    private UserinformationService userinformationService;

    /**
     * 展示个人信息
     * @param userinformation
     * @return
     */
    @PostMapping("/display")
    public Display_Update_DTO display(@RequestBody Userinformation userinformation){
        return userinformationService.display(userinformation);
    }

    @PostMapping("/update")
    public Display_Update_DTO update(@RequestBody Userinformation userinformation){
        return userinformationService.update(userinformation);
    }

    @PostMapping("/update-health")
    public Display_Update_DTO update2(@RequestBody Userinformation userinformation){
        return userinformationService.update2(userinformation);
    }
}