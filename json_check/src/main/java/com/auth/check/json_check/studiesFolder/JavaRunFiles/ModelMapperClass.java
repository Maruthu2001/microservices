package com.auth.check.json_check.studiesFolder.JavaRunFiles;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import com.auth.check.json_check.studiesFolder.commonDto.UserCheckDto;
import com.auth.check.json_check.studiesFolder.commonDto.UserCheckDto1;

public class ModelMapperClass {
    
    
    public static void main(String[] args) {        
        ModelMapper modMapper = new ModelMapper();
        
        TypeMap<UserCheckDto, UserCheckDto1> typeMap = modMapper.createTypeMap(UserCheckDto.class, UserCheckDto1.class);
        
        typeMap.addMappings(mapper -> {
            mapper.map(src -> src.getFirstname() + src.getLastname(), UserCheckDto1::setFullname);   
        });
        
        UserCheckDto userCheckDto = new UserCheckDto();
        userCheckDto.setFirstname("Dinesh");
        userCheckDto.setLastname("Alagarsamy");
        
        UserCheckDto1 userCheckDto1 = modMapper.map(userCheckDto, UserCheckDto1.class);
        
        
        System.out.println(userCheckDto1.getFirstname() + "/n" + userCheckDto1.getLastname() + "/n" + userCheckDto1.getFullname());
    }
}
