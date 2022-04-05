package com.example.lnb.controller;

import com.example.lnb.entity.Activities;
import com.example.lnb.entity.dto.Activity_Add_DTO;
import com.example.lnb.service.ActivityaddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityaddController {
    @Autowired
    private ActivityaddService activityaddService;

    @RequestMapping("/activity-add")
    public Activity_Add_DTO addd(@RequestBody Activities activities) {
        return activityaddService.addd(activities);
    }
}