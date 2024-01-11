package com.tobeto.spring.b.repositories;

import com.tobeto.spring.b.entities.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {
    List<Customers> findCustomersByNameAndSurnameOrPhoneOrGmail(String name, String surname, String phone, String gmail);
   // boolean existsById(int id);
}
