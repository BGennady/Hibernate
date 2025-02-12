package ru.netology.Hibernate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, PersonID> {

    List<Person> findByCityOfLiving(String cityOfLiving);

    List<Person> findByPersonID_AgeLessThanOrderByPersonID_AgeAsc(int age);

    Optional<Person> findByPersonID_NameAndPersonID_Surname(String name, String surname);
}
