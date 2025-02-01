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
    @JoinColumn(name = "personId", nullable=false)
    private Person person;
}
