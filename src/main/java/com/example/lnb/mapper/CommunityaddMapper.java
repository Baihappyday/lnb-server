package com.example.lnb.mapper;

import com.example.lnb.entity.Communities;
import com.example.lnb.entity.Communityusers;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CommunityaddMapper {
    @Select("SELECT * FROM Communityusers WHERE Communityusers.cusername=#{ccusername}")
    Communityusers findcommunitybyccusername(@Param("ccusername") String ccusername);

    @Insert("INSERT INTO Communities VALUES (#{ccusername},#{caddress},#{cname},#{cdescription})")
    void communityadd(Communities communities);
}
