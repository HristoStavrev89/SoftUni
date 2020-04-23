package app.domain;

import app.domain.entities.Person;
import app.domain.entities.Student;
import app.domain.entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {



        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("codeFirst");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Student student = new Student("Gosho", "Georgiev", 8);
        Teacher teacher = new Teacher("Dimitar", "Dimitrov", "Java");

        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.persist(teacher);
        entityManager.getTransaction().commit();
        entityManager.close();




    }
}
