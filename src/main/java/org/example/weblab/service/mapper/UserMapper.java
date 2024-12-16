package org.example.weblab.service.mapper;

import org.example.weblab.entity.User;
import org.example.weblab.web.dto.request.UserDtoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "loyaltyPoints", expression = "java(0)")
    User userDtoRequestToUserEntity(UserDtoRequest userDtoRequest);
}
