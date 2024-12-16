package org.example.weblab.repository;

import org.example.weblab.entity.CompositionDish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompositionDishRepository extends JpaRepository<CompositionDish, UUID> {
}
