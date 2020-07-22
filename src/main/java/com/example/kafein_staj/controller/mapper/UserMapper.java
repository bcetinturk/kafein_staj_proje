package com.example.kafein_staj.controller.mapper;

import com.example.kafein_staj.datatransferobject.UserDTO;
import com.example.kafein_staj.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface UserMapper {
    UserDTO userToUserDTO(User userEntity);
    User userDTOToUser(UserDTO userDTO);
}
