package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepository extends JpaRepository<Payments, Integer> {
}
