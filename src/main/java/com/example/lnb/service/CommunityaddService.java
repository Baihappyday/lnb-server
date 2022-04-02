package com.example.lnb.service;

import com.example.lnb.entity.Communities;
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
            Communities communities1 = communityaddMapper.findcommunitybyccusername(communities.getCcusername());
            if(communities1!=null){
                result.setMsg("true");
                communities1.setCcusername(communities.getCcusername());
                communities1.setCaddress(communities.getCaddress());
                communities1.setCname(communities.getCname());
                communities1.setCdescription(communities.getCdescription());
                communityaddMapper.communityadd(communities);
                result.setCaddress(communities1.getCaddress());
                result.setCcusername(communities1.getCcusername());
                result.setCname(communities1.getCname());
                result.setCdescription(communities1.getCdescription());
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
