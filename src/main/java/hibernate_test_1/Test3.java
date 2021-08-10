package hibernate_test_1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee1.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
//            List<Employee> emps = session.createQuery("from Employee")
//                            .getResultList();

            List<Employee1> emps = session.createQuery("from Employee1 " +
                            "where firstName = 'alex' AND salary>1000")
                            .getResultList();
            for (Employee1 e: emps) System.out.println(e);

            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
