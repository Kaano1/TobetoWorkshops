package com.tobeto.spring.b.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "payments")
public class Payments {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "pay_amount")
    private int limit;

    @Column(name = "card_number")
    private String cardNumber;

    @ManyToOne
    @JoinColumn(name = "agreement")
    private Orders orders;
}
