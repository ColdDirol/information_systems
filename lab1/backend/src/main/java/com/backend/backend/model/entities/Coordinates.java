package com.backend.backend.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
public class Coordinates {

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private Double x; //Максимальное значение поля: 7, Поле не может быть null

    @Column
    private Long y; //Значение поля должно быть больше -487
}
