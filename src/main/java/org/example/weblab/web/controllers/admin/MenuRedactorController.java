package org.example.weblab.web.controllers.admin;

import lombok.AllArgsConstructor;
import org.example.weblab.entity.Dish;
import org.example.weblab.service.MenuRedactorService;
import org.example.weblab.web.dto.request.DishDtoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("${app.admin-endpoint}/menu")
@AllArgsConstructor
public class MenuRedactorController {

    private final MenuRedactorService menuRedactorService;

    @PostMapping("/dish/create")
    public UUID createDish(@RequestBody DishDtoRequest dish) {
        return menuRedactorService.createDish(dish);
    }

    @GetMapping("/dish/get/{id}")
    public Dish getDish(@PathVariable UUID id) {
        return menuRedactorService.getDish(id);
    }

    @PostMapping("/dish/update/{id}")
    public Dish updateDish(@PathVariable UUID id, @RequestBody DishDtoRequest dish) {
        return menuRedactorService.updateDish(id, dish);
    }

    @PostMapping("/dish/delete/{id}")
    public ResponseEntity<Void> deleteDish(@PathVariable UUID id) {
        return menuRedactorService.deleteDish(id);
    }
}
