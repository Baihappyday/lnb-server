package com.example.lnb.controller;

import com.example.lnb.entity.Institutions;
import com.example.lnb.mapper.InstitutionsMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/institutions")
public class InstitutionsController {

    @Resource
    InstitutionsMapper institutionsMapper;

    @GetMapping("/all")
    public List<Institutions> getInstitutions(){
        return institutionsMapper.findAll();
    }


    @RequestMapping("/find")
    public Institutions findByIname(@RequestParam("iname") String iname){
        return institutionsMapper.findByIname(iname);

    }


}
