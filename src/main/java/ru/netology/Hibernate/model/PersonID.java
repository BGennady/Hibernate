package ru.netology.Hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter

// класс для указания первичного составного ключа
@Embeddable
public class PersonID implements Serializable {
    @Column (nullable = false)
    private String name;
    @Column (nullable = false)
    private String surname;
    @Column (nullable = false)
    private int age;
}