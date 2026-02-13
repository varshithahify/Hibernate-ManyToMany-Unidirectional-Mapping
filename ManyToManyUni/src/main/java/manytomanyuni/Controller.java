package manytomanyuni;

import javax.persistence.*;
import java.util.Arrays;

public class Controller {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("dev");

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Course c1 = new Course();
        c1.setCourse_id(101);
        c1.setCourseName("Java");

        Course c2 = new Course();
        c2.setCourse_id(102);
        c2.setCourseName("SQL");

        Student s = new Student();
        s.setStudent_id(1);
        s.setName("Varsha");

        s.setCourses(Arrays.asList(c1, c2));

        et.begin();
        em.persist(c1);
        em.persist(c2);
        em.persist(s);
        et.commit();

        System.out.println("Many-To-Many Unidirectional Done");
    }
}
