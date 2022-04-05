package com.example.lnb.service;

import com.example.lnb.entity.Activities;
import com.example.lnb.entity.dto.Activity_Add_DTO;
import com.example.lnb.mapper.ActivityaddMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityaddService {
    @Autowired
    private ActivityaddMapper activityaddMapper;

    public Activity_Add_DTO addd(Activities activities){
        Activity_Add_DTO result = new Activity_Add_DTO();
        try{
            Activities activities1 = new Activities();
            result.setMsg("true");
            activities1.setActivityaddress(activities.getActivityaddress());
            activities1.setActivitytime(activities.getActivitytime());
            activities1.setActivitydescription(activities.getActivitydescription());
            activityaddMapper.activityadd(activities);
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg("error");
        }
        return result;
    }
}