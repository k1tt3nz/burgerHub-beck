package org.example.weblab.web.dto.response;

import lombok.Builder;
import org.example.weblab.entity.Dish;

import java.util.List;

@Builder
public record MenuDtoResponse(

        List<Dish> burgers,
        List<Dish> pizza,
        List<Dish> salads
){}
