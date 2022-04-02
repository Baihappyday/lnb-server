package com.example.lnb.mapper;

import com.example.lnb.entity.Activities;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ActivitiesMapper {

    @Select("Select * FROM Activities")
    List<Activities> findAll();

    @Select("SELECT * FROM Activities WHERE AID=#{AID}")
    Activities findByAID(Integer AID);
}
