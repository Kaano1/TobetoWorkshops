package com.tobeto.spring.b.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payments")
public class Payments {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @ManyToOne
    @JoinColumn(name="agreement")
    public Orders agreement;

    @Column(name = "pay_method")
    public String payMethod;

    @Column(name = "pay_amount")
    public int amount;

    @Column(name = "card_number")
    public int cardNumber;
}
