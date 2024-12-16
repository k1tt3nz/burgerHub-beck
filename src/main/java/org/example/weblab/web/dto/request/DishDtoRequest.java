package org.example.weblab.web.dto.request;

public record DishDtoRequest(

        String name,

        String type,

        Integer price,

        String description,

        String imageUrl,

        Composition composition
){

    public record Composition (

            Integer protein,

            Integer fats,

            Integer carbohydrate,

            Integer calories,

            String description,

            String allergens
    ){
    }
}
