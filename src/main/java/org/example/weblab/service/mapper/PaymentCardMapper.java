package org.example.weblab.service.mapper;

import org.example.weblab.entity.PaymentCard;
import org.example.weblab.entity.User;
import org.example.weblab.web.dto.request.PaymentCardDtoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface PaymentCardMapper {

    @Mapping(target = "user", source = "userId", qualifiedByName = "mapUserIdToUser")
    @Mapping(target = "major", defaultValue = "false")
    PaymentCard paymentCardDtoRequestToPaymentCard(PaymentCardDtoRequest paymentCardDtoRequest);

    @Named("mapUserIdToUser")
    default User mapUserIdToUser(UUID userId) {
        if (userId != null) {
            User user = new User();
            user.setId(userId);
            return user;
        }
        return null;
    }
}
