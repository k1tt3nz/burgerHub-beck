package org.example.weblab.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.example.weblab.entity.User;
import org.example.weblab.repository.PaymentCardRepository;
import org.example.weblab.repository.UserRepository;
import org.example.weblab.service.mapper.PaymentCardMapper;
import org.example.weblab.service.mapper.UserMapper;
import org.example.weblab.web.dto.request.PaymentCardDtoRequest;
import org.example.weblab.web.dto.request.UserAuthRequest;
import org.example.weblab.web.dto.request.UserDtoRequest;
import org.example.weblab.web.dto.response.UserAuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class UserService {

    private final UserMapper userMapper;
    private final PaymentCardMapper paymentCardMapper;
    private final UserRepository userRepository;
    private final PaymentCardRepository paymentCardRepository;
    private final AuthService authService;

    public UUID createUser(UserDtoRequest userDtoRequest){
        return userRepository.save(userMapper.userDtoRequestToUserEntity(userDtoRequest)).getId();
    }

    @Transactional(readOnly = true)
    public User getUser(UUID id){
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

    public User updateUser(UUID id, UserDtoRequest userDtoRequest) {
        return userRepository.findById(id)
                .map(dish -> {
                    User user = userMapper.userDtoRequestToUserEntity(userDtoRequest);
                    user.setId(id);
                    userRepository.save(user);
                    return user;
                })
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }

    public ResponseEntity<Void> deleteUser(UUID id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    public UUID addPaymentCard(PaymentCardDtoRequest paymentCardDtoRequest) {
        return paymentCardRepository.save(paymentCardMapper.paymentCardDtoRequestToPaymentCard(paymentCardDtoRequest)).getId();
    }

    public ResponseEntity<Void> deletePaymentCard(UUID id) {
        if (paymentCardRepository.existsById(id)) {
            paymentCardRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
/*
    public UserAuthResponse auth(UserAuthRequest user) {
        return authService.authenticateUser(user);
    }

 */
}
