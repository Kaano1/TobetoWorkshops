package com.tobeto.spring.b.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "orderss")
public class Orders {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "amount")
    private int amount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customer;

    @ManyToOne
    @JoinColumn(name = "cars_id")
    private Cars car;

    @OneToMany(mappedBy = "orders")
    @JsonIgnore
    private List<Payments> payments;
}
