package hibernate_test_1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee1.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Employee1 emp = new Employee1("Oleg",
                    "Sidorov", "HR", 700);
            session.beginTransaction();
            session.save(emp);
//            session.getTransaction().commit();

            int myId = emp.getId();
//            session = factory.getCurrentSession();
//            session.beginTransaction();
            Employee1 employee1 = session.get(Employee1.class, myId);
            session.getTransaction().commit();

            System.out.println(employee1);

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }
}
