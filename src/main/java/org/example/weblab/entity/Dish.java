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
@Table(name = "dish")
@EntityListeners(AuditingEntityListener.class)
public class Dish {

    @Id
    @GeneratedValue()
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "composition_dish", referencedColumnName = "id", nullable = false)
    private CompositionDish composition;

    @Column(nullable = false, unique = true)
    private String name;

    private String type;

    private int price;

    private String description;

    @Column(name = "image_url")
    private String imageUrl;
}