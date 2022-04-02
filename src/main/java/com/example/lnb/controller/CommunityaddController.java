package com.example.lnb.controller;

import com.example.lnb.entity.Communities;
import com.example.lnb.entity.dto.Community_Add_DTO;
import com.example.lnb.service.CommunityaddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommunityaddController {
    @Autowired
    private CommunityaddService communityaddService;

    @RequestMapping("/community-add")
    public Community_Add_DTO add(@RequestBody  Communities communities){
        return communityaddService.add(communities);
    }
}