package org.example.weblab.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.example.weblab.entity.Dish;
import org.example.weblab.repository.DishRepository;
import org.example.weblab.service.mapper.DishMapper;
import org.example.weblab.web.dto.request.DishDtoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class MenuRedactorService {

    private final DishMapper dishMapper;
    private final DishRepository dishRepository;

    public UUID createDish(DishDtoRequest dishDtoRequest){
        return dishRepository.save(dishMapper.dishRequestToDishEntity(dishDtoRequest)).getId();
    }

    @Transactional(readOnly = true)
    public Dish getDish(UUID id){
        Optional<Dish> dish = dishRepository.findById(id);
        return dish.orElseThrow(() -> new EntityNotFoundException("Dish not found with id: " + id));
    }

    public Dish updateDish(UUID id, DishDtoRequest dishDtoRequest) {
        return dishRepository.findById(id)
                .map(dish -> {
                    Dish dishEntity = dishMapper.dishRequestToDishEntity(dishDtoRequest);
                    dishEntity.setId(id);
                    dishRepository.save(dishEntity);
                    return dishEntity;
                })
                .orElseThrow(() -> new EntityNotFoundException("Dish not found with id: " + id));
    }

    public ResponseEntity<Void> deleteDish(UUID id) {
        if (dishRepository.existsById(id)) {
            dishRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
