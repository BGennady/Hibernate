package ru.netology.Hibernate;

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

    @OneToMany (mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + personID.getName() + '\'' +
                ", surname='" + personID.getSurname() + '\'' +
                ", age=" + personID.getAge() +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cityOfLiving='" + cityOfLiving + '\'' +
                '}';
    }

}
