package com.example.carservice.entity;

import com.example.carservice.enums.Status;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private int year;

    @Column(name = "problem")
    private String problem;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

}
