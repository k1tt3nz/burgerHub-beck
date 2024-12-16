package org.example.weblab.service;

import lombok.RequiredArgsConstructor;
import org.example.weblab.entity.Dish;
import org.example.weblab.repository.DishRepository;
import org.example.weblab.web.dto.response.MenuDtoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MenuService {

    private final DishRepository dishRepository;

    public ResponseEntity<List<Dish>> getBurgers() {
        Optional<List<Dish>> dish = dishRepository.findAllByType("burger");
        return dish.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<Dish>> getPizza() {
        Optional<List<Dish>> dish = dishRepository.findAllByType("pizza");
        return dish.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<List<Dish>> getSalad() {
        Optional<List<Dish>> dish = dishRepository.findAllByType("salad");
        return dish.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<MenuDtoResponse> getMenu() {
        Optional<List<Dish>> burgers = dishRepository.findAllByType("burger");
        Optional<List<Dish>> pizzas = dishRepository.findAllByType("pizza");
        Optional<List<Dish>> salad = dishRepository.findAllByType("salad");

        MenuDtoResponse menu = MenuDtoResponse.builder()
                .burgers(burgers.get())
                .pizza(pizzas.get())
                .salads(salad.get())
                .build();

        return ResponseEntity.ok(menu);
    }
}
