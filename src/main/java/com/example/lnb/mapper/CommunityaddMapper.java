package com.example.lnb.mapper;

import com.example.lnb.entity.Communities;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CommunityaddMapper {
    @Select("SELECT * FROM Communityusers join Communities WHERE Communities.ccusername=Communityusers.cusername and Communities.ccusername=#{ccusername}")
    Communities findcommunitybyccusername(@Param("ccusername") String ccusername);

    @Update("update Communities set caddress=#{caddress},cname=#{cname},cdescription=#{cdescription} where ccusername=#{ccusername}")
    void communityadd(Communities communities);
}
