package com.thn.restpetstore.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;

@NoArgsConstructor
@Getter
@Setter
@Document("user_cars")
public class Car {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
}
