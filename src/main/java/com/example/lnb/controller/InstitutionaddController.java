package com.example.lnb.controller;


import com.example.lnb.entity.Institutions;
import com.example.lnb.entity.dto.Institution_Add_DTO;
import com.example.lnb.service.InstituotionaddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InstitutionaddController {
    @Autowired
    private InstituotionaddService instituotionaddService;

    @RequestMapping("/institution-add")
    public Institution_Add_DTO add(@RequestBody Institutions institutions){
        return instituotionaddService.add(institutions);
    }
}
