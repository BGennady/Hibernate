package ru.netology.Hibernate;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "ORDERS", schema = "hibernete")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String data;

    @Column(nullable = false)
    private int numOrder;

    @Column(nullable = false)
    private int amount;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "person_name", referencedColumnName = "name", nullable = false),
            @JoinColumn(name = "person_surname", referencedColumnName = "surname", nullable = false),
            @JoinColumn(name = "person_age", referencedColumnName = "age", nullable = false)
    })
    private Person person;
}
