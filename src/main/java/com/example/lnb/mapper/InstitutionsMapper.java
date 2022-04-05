package com.example.lnb.mapper;

import com.example.lnb.entity.Institutions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InstitutionsMapper {

    @Select("Select * FROM Institutions")
    List<Institutions> findAll();

    @Select("SELECT * FROM Institutions WHERE iname=#{iname}")
    Institutions findByIname(String iname);
}
