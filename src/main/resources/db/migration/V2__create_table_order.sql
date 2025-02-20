
CREATE TABLE hibernate.ORDERS(
    id BIGINT GENERATED BY DEFAULT AS IDENTITY,

    person_name VARCHAR (25) NOT NULL,
    person_surname VARCHAR (35) NOT NULL,
    person_age INT NOT NULL,
    date DATE NOT NULL,
    num_order INT NOT NULL,
    amount INT NOT NULL,


    PRIMARY KEY (id),
    FOREIGN KEY (person_name,person_surname,person_age) REFERENCES hibernate.PERSONS(name,surname,age)
);