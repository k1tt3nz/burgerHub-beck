package org.example.weblab.web.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserDtoRequest (

        @NotNull String surname,
        @NotNull String firstname,
        String patronymic,
        @NotNull String phoneNumber,
        @NotNull String password,
        @Email String email,
        String address
){
}
