package ru.netology.Hibernate;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "PERSONS", schema = "hibernate")

public class Person {

    @EmbeddedId
    private PersonID personID;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String cityOfLiving;

    @Override
    public String toString() {
        return "Person{" +
                "personID=" + personID +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cityOfLiving='" + cityOfLiving + '\'' +
                ", orders=" + orders +
                '}';
    }

    @JsonManagedReference
    @OneToMany (mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;
}
