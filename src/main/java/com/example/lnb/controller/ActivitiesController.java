package com.example.lnb.controller;

import com.example.lnb.entity.Activities;
import com.example.lnb.mapper.ActivitiesMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivitiesController {

    @Resource
    ActivitiesMapper activities;

    @GetMapping("/all")
    public List<Activities> getInstitutions(){
        return activities.findAll();
    }

    @RequestMapping("/find")
    public Activities findByAID(@RequestParam("AID") Integer AID){
        return activities.findByAID(AID);
    }
}
