package com.backend.backend.model.entities;

import com.backend.backend.model.enumeration.MovieGenreEnum;
import com.backend.backend.model.enumeration.MpaaRatingEnum;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Movie {

    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name; //Поле не может быть null, Строка не может быть пустой

    @OneToOne(optional = false)
    @JoinColumn(name = "coordinates_id", nullable = false)
    private Coordinates coordinates; //Поле не может быть null

    @Column(nullable = false)
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически

    @Column
    private Integer oscarsCount; //Значение поля должно быть больше 0

    @Column(nullable = false)
    private Integer budget; //Значение поля должно быть больше 0, Поле не может быть null

    @Column
    private Integer totalBoxOffice; //Значение поля должно быть больше 0

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MpaaRatingEnum mpaaRatingEnum; //Поле не может быть null

    @OneToOne(optional = false)
    @JoinColumn(name = "director_id", nullable = false)
    private Person director; //Поле может быть null

    @OneToOne(optional = false)
    @JoinColumn(name = "screenwriter_id", nullable = false)
    private Person screenwriter;

    @OneToOne(optional = false)
    @JoinColumn(name = "operator_id", nullable = false)
    private Person operator; //Поле может быть null

    @Column
    private Integer length; //Значение поля должно быть больше 0

    @Column
    private Long goldenPalmCount; //Значение поля должно быть больше 0, Поле может быть null

    @Column(nullable = false)
    private Long usaBoxOffice; //Поле не может быть null, Значение поля должно быть больше 0

    @Column(nullable = false)
    private String tagline; //Поле не может быть null

    @Column
    @Enumerated(EnumType.STRING)
    private MovieGenreEnum genre; //Поле может быть null
}
