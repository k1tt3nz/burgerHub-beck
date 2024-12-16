package org.example.weblab.web.controllers;

import lombok.AllArgsConstructor;
import org.example.weblab.entity.Dish;
import org.example.weblab.service.MenuService;
import org.example.weblab.util.annotations.swagger.DocumentedOperation;
import org.example.weblab.web.dto.response.MenuDtoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("${app.base-endpoint}/dish/")
@AllArgsConstructor
public class MenuController {

    private final MenuService dishService;

    @GetMapping("")
    public ResponseEntity<MenuDtoResponse> getMenu() {
        return dishService.getMenu();
    }
}
