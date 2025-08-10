package com.app1.app1.mappings;

import org.mapstruct.Mapper;

import com.app1.app1.dtos.User;
import com.app1.app1.dtos.UserDto;

@Mapper
public interface UserMapper {

	UserDto toDto(User user);

}
