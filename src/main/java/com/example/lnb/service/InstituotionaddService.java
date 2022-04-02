package com.example.lnb.service;

import com.example.lnb.entity.Institutions;
import com.example.lnb.entity.dto.Institution_Add_DTO;
import com.example.lnb.mapper.InstitutionaddMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstituotionaddService {
    @Autowired
    private InstitutionaddMapper institutionaddMapper;

    public Institution_Add_DTO add(Institutions institutions){
        Institution_Add_DTO result = new Institution_Add_DTO();
        try{
            Institutions institutions1 = institutionaddMapper.findinstitutionbyiiusername(institutions.getIiusername());
            if(institutions1!=null){
                result.setMsg("true");
                institutions1.setIiusername(institutions.getIiusername());
                institutions1.setIaddress(institutions.getIaddress());
                institutions1.setIname(institutions.getIname());
                institutions1.setIdescription(institutions.getIdescription());
                institutionaddMapper.institutionadd(institutions);
                result.setIaddress(institutions1.getIaddress());
                result.setIiusername(institutions1.getIiusername());
                result.setIname(institutions1.getIname());
                result.setIdescription(institutions1.getIdescription());
            }
            else{
                result.setMsg("false");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg("error");
        }
        return result;
    }
}
