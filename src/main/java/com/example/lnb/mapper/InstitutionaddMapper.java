package com.example.lnb.mapper;

import com.example.lnb.entity.Institutions;
import com.example.lnb.entity.Institutionusers;
import org.apache.ibatis.annotations.*;

@Mapper
public interface InstitutionaddMapper {
    @Select("SELECT * FROM Institutionusers WHERE Institutionusers.iusername=#{iiusername}")
    Institutionusers findinstitutionbyiiusername(@Param("iiusername") String iiusername);

    @Insert("INSERT INTO Institutions VALUES (#{iiusername},#{iaddress},#{iname},#{iprice},#{idescription})")
    void institutionadd(Institutions institutions);
}
