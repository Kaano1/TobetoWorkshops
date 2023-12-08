package com.tobeto.spring.b.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone")
    private String phoneNumber;

    @Column(name = "gmail")
    private String gmail;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address addresss;

    @OneToMany(mappedBy = "customers")
    @JsonIgnore
    private List<Orders> orders;
}
