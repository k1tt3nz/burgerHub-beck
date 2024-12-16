package org.example.weblab.service.mapper;

import org.example.weblab.entity.CompositionDish;
import org.example.weblab.entity.Dish;
import org.example.weblab.web.dto.request.DishDtoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DishMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "composition", source = "composition")
    Dish dishRequestToDishEntity(DishDtoRequest dishDtoRequest);

    @Mapping(target = "id", ignore = true)
    CompositionDish mapComposition(DishDtoRequest.Composition composition);
}
