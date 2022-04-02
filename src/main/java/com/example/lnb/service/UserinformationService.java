package com.example.lnb.service;

import com.example.lnb.entity.Userinformation;
import com.example.lnb.entity.dto.Display_Update_DTO;
import com.example.lnb.mapper.UserinformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserinformationService {
    @Autowired
    private UserinformationMapper userinformationMapper;
    /**
     * 展示个人信息
     * @param userinformation
     * @return
     */
    public Display_Update_DTO display(Userinformation userinformation){
        Display_Update_DTO result = new Display_Update_DTO();
        try{
            Userinformation userinformation1 = userinformationMapper.findUserinformation(userinformation.getUusername());
            if(userinformation1!=null){
                result.setMsg("true");
                result.setUage(userinformation1.getUage());
                result.setUaddress(userinformation1.getUaddress());
                result.setUsex(userinformation1.getUsex());
                result.setUphone(userinformation1.getUphone());
                result.setUbloodtype(userinformation1.getUbloodtype());
                result.setUhealthcondition(userinformation1.getUhealthcondition());
            }else{
                result.setMsg("false");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg("error");
        }
        return result;
    }
    public Display_Update_DTO update(Userinformation userinformation){
        Display_Update_DTO result = new Display_Update_DTO();
        try{
            Userinformation userinformation1 = userinformationMapper.findUserinformation(userinformation.getUusername());
            if(userinformation1!=null){
                userinformation1.setUage(userinformation.getUage());
                userinformation1.setUaddress(userinformation.getUaddress());
                userinformation1.setUsex(userinformation.getUsex());
                userinformation1.setUphone(userinformation.getUphone());
                /*userinformation1.setUbloodtype(userinformation.getUbloodtype());
                userinformation1.setUhealthcondition(userinformation.getUhealthcondition());*/
                userinformationMapper.updateInfoByuusername(userinformation);
                result.setMsg("true");
                result.setUage(userinformation.getUage());
                result.setUaddress(userinformation.getUaddress());
                result.setUsex(userinformation.getUsex());
                result.setUphone(userinformation.getUphone());
                /*result.setUbloodtype(userinformation.getUbloodtype());
                result.setUhealthcondition(userinformation.getUhealthcondition());*/
            }else{
                result.setMsg("false");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setMsg("error");
        }
        return result;
    }

    public Display_Update_DTO update2(Userinformation userinformation){
        Display_Update_DTO result1= new Display_Update_DTO();
        try{
            Userinformation userinformation1 = userinformationMapper.findUserinformation(userinformation.getUusername());
            if(userinformation1!=null){
                userinformation1.setUbloodtype(userinformation.getUbloodtype());
                userinformation1.setUhealthcondition(userinformation.getUhealthcondition());
                userinformationMapper.updateHealthByuusername(userinformation);
                result1.setMsg("true");
                result1.setUbloodtype(userinformation.getUbloodtype());
                result1.setUhealthcondition(userinformation.getUhealthcondition());
            }else{
                result1.setMsg("false");
            }
        }catch (Exception e){
            e.printStackTrace();
            result1.setMsg("error");
        }
        return result1;
    }





}
