package org.example.weblab.web.controllers;

import lombok.AllArgsConstructor;
import org.example.weblab.entity.User;
import org.example.weblab.service.UserService;
import org.example.weblab.web.dto.request.PaymentCardDtoRequest;
import org.example.weblab.web.dto.request.UserAuthRequest;
import org.example.weblab.web.dto.request.UserDtoRequest;
import org.example.weblab.web.dto.response.UserAuthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("${app.base-endpoint}/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public UUID createUser(@RequestBody UserDtoRequest user) {
       return userService.createUser(user);
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable UUID id) {
        return userService.getUser(id);
    }

    @PostMapping("/update/{id}")
    public User updateUser(@PathVariable UUID id, @RequestBody UserDtoRequest user) {
        return userService.updateUser(id, user);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        return userService.deleteUser(id);
    }

    @PostMapping("/card/add")
    public UUID deleteUser(@RequestBody PaymentCardDtoRequest paymentCard) {
        return userService.addPaymentCard(paymentCard);
    }

    @PostMapping("/card/delete/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable UUID id) {
        return userService.deletePaymentCard(id);
    }

    /*
    @PostMapping("/auth")
    public UserAuthResponse auth(@RequestBody UserAuthRequest user) {
        return userService.auth(user);
    }

     */
}
