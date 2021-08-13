package hibernate_one_to_many_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee3.class)
                .addAnnotatedClass(Department1.class)
                .buildSessionFactory();

        Session session = null;

        try {
//            session = factory.getCurrentSession();
//            Department1 department = new Department1("IT",
//                    300, 1200);
//            Employee3 emp1 = new Employee3("yuriy",
//                    "belov", 800);
//            Employee3 emp2 = new Employee3("lena",
//                    "smirnova", 1000);
//            Employee3 emp3 = new Employee3("anton",
//                    "sidorov", 1200);
//            department.addEmployeeToDepartment(emp1);
//            department.addEmployeeToDepartment(emp2);
//            department.addEmployeeToDepartment(emp3);
//
//            session.beginTransaction();
//            session.save(department);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

//***********************************************************

            session = factory.getCurrentSession();

            session.beginTransaction();
            System.out.println("Get department");
            Department1 department = session.get(Department1.class, 3);
            System.out.println("Show department");
            System.out.println(department);
            System.out.println("Show employees of the department");
            System.out.println("Подгрузка работников");
            department.getEmps().get(0);

            session.getTransaction().commit();

            System.out.println("Show employees of the department");
            System.out.println(department.getEmps());
            System.out.println("Done!");
//***********************************************************
//
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 1);
//            System.out.println(employee);
//            System.out.println(employee.getDepartment());
//
//            session.getTransaction().commit();
//            System.out.println("Done!");

//***********************************************************

//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Employee3 employee = session.get(Employee3.class, 2);
//            session.delete(employee);
//
//            session.getTransaction().commit();
//            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();

        }
    }
}
