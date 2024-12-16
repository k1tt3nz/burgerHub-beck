package org.example.weblab.web.dto.request;

import java.util.UUID;

public record PaymentCardDtoRequest (
        UUID userId,
        String number,
        String expiryDate,
        Boolean major
){
}
