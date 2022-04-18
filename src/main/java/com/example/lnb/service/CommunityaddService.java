package com.example.lnb.service;

import com.example.lnb.entity.Communities;
import com.example.lnb.entity.Communityusers;
import com.example.lnb.entity.dto.Community_Add_DTO;
import com.example.lnb.mapper.CommunityaddMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommunityaddService {
    @Autowired
    private CommunityaddMapper communityaddMapper;

    public Community_Add_DTO add(Communities communities){
        Community_Add_DTO result = new Community_Add_DTO();
        try{
            Communityusers communities1 = communityaddMapper.findcommunitybyccusername(communities.getCcusername());
            if(communities1!=null){
                result.setMsg("true");
                communityaddMapper.communityadd(communities);
                result.setCaddress(communities.getCaddress());
                result.setCcusername(communities.getCcusername());
                result.setCname(communities.getCname());
                result.setCdescription(communities.getCdescription());
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
