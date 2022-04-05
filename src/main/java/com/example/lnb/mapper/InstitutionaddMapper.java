package com.example.lnb.mapper;

import com.example.lnb.entity.Institutions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface InstitutionaddMapper {
    @Select("SELECT * FROM Institutionusers join Institutions WHERE Institutions.iiusername=Institutionusers.iusername and Institutions.iiusername=#{iiusername}")
    Institutions findinstitutionbyiiusername(@Param("iiusername") String iiusername);

    @Update("update Institutions set iaddress=#{iaddress},iname=#{iname},iprice=#{iprice},idescription=#{idescription} where iiusername=#{iiusername}")
    void institutionadd(Institutions institutions);
}
