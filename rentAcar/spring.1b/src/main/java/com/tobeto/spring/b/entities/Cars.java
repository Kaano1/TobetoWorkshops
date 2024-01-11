package com.tobeto.spring.b.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "cars")
public class Cars {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "model_year")
    private String modeYear;

    @Column(name = "model_name")
    private String modelName;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brands brand;

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    private List<Orders> orders;
}
