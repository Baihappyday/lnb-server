package com.example.lnb.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


@Data
public class Activity_Add_DTO {
    private String msg;
    private Integer AID;
    private String activitytime;
    private String activityaddress;
    private String activitydescription;
}