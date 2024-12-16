package org.example.weblab.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.UUID;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "composition_dish")
@EntityListeners(AuditingEntityListener.class)
public class CompositionDish {

    @Id
    @GeneratedValue()
    private UUID id;

    @Column(nullable = false)
    private int protein;

    @Column(nullable = false)
    private int fats;

    @Column(nullable = false)
    private int carbohydrate;

    @Column(nullable = false)
    private int calories;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String allergens;
}