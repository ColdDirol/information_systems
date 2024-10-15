package com.backend.backend.model.entities;

import com.backend.backend.model.enumeration.ColorEnum;
import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Entity
public class Person {

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name; //Поле не может быть null, Строка не может быть пустой

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ColorEnum eyeColorEnum; //Поле не может быть null

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ColorEnum hairColorEnum; //Поле не может быть null

    @OneToOne(optional = false)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location; //Поле не может быть null

    @Column(nullable = false)
    private ZonedDateTime birthday; //Поле может быть null
}
