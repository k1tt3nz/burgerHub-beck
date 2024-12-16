package org.example.weblab.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "payment_card")
@EntityListeners(AuditingEntityListener.class)
public class PaymentCard {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_user_payment_cards_id"))
    @JsonBackReference
    private User user;

    private String number;

    private String expiryDate;

    @Column(name = "is_major")
    private boolean major;
}
