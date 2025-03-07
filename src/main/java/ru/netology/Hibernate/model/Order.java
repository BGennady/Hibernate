package ru.netology.Hibernate.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ORDERS", schema = "hibernate")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private int numOrder;

    @Column(nullable = false)
    private int amount;

    @JsonBackReference
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "person_name", referencedColumnName = "name", nullable = false),
            @JoinColumn(name = "person_surname", referencedColumnName = "surname", nullable = false),
            @JoinColumn(name = "person_age", referencedColumnName = "age", nullable = false)
    })
    private Person person;
}