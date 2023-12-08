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
@Table(name="cars")
public class Car
{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="model_year")
    private int modelYear;

    @Column(name = "model_name", length = 100)
    private String modelName;

    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brands;

    @OneToMany(mappedBy = "cars")
    @JsonIgnore
    private List<Orders> orderss;
}
