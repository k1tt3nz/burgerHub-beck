package org.example.weblab.repository;

import org.example.weblab.entity.PaymentCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentCardRepository extends JpaRepository<PaymentCard, UUID> {
}
