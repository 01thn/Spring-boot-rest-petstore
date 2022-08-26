package com.thn.restpetstore.mapper;

import com.thn.restpetstore.dto.UserDTO;
import com.thn.restpetstore.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toUserDto(User user);

    User fromDtoToUser(UserDTO userDTO);

}
