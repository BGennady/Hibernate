package ru.netology.Hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ru.netology.Hibernate.model.Person;

import java.util.List;

@Repository
public class PersonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Person> getPersonsByCity(String city) {

        //тело запроса
        String jpql = "SELECT p FROM Person p WHERE  p.cityOfLiving = :city";
        return entityManager.createQuery(jpql, Person.class)
                //подставляю city из метода в city запроса
                .setParameter("city", city)
                //возращает список
                .getResultList();


//        //объект для написания динамических и гибких SQL запросов в Hibernet
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        //объект описывает структуру запроса в Hibernet
//        CriteriaQuery<Person> cr = criteriaBuilder.createQuery(Person.class);
//        //корень запроса - указывает, из какой таблицы (сущности) выбираем данные
//        Root<Person> root = cr.from(Person.class);
//        //условие отбора (Predicate) - cityOfLiving должен совпадать с переданным значением города
//        Predicate condition = criteriaBuilder.equal(root.get("cityOfLiving"), city);
//        //добавляю условие CriteriaQuery
//        cr.where(condition);
//        //запрос
//        List<Person> result = entityManager.createQuery(cr).getResultList();
//        return result;
    }
}