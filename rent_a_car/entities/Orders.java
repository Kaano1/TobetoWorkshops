package com.tobeto.spring.b.entities;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Orders {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "amount")
    private int amount;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car cars;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customers;

}
