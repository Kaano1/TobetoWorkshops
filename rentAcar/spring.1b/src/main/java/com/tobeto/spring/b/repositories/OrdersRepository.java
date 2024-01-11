package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Integer>
{
}
