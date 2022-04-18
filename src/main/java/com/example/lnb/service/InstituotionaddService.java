package com.example.lnb.service;

import com.example.lnb.entity.Institutions;
import com.example.lnb.entity.Institutionusers;
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
            Institutionusers institutions1 = institutionaddMapper.findinstitutionbyiiusername(institutions.getIiusername());
            if(institutions1!=null){
                result.setMsg("true");
                institutionaddMapper.institutionadd(institutions);
                result.setIaddress(institutions.getIaddress());
                result.setIiusername(institutions.getIiusername());
                result.setIname(institutions.getIname());
                result.setIprice(institutions.getIprice());
                result.setIdescription(institutions.getIdescription());
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
