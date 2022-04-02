package com.example.lnb.mapper;

import com.example.lnb.entity.Activities;

import org.apache.ibatis.annotations.*;


@Mapper
public interface ActivityaddMapper {

    @Select("SELECT * FROM Activities  WHERE AID=#{AID}")
    Activities findactivitybyAID(@Param("AID") Integer AID);

    @Insert("INSERT INTO Activities(activitytime,activityaddress,activitydescription) VALUES (#{activitytime},#{activityaddress},#{activitydescription})")
    void activityadd(Activities activities);
}