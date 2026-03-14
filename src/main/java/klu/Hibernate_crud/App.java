package klu.Hibernate_crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        
        SessionFactory factory = config.buildSessionFactory();
        
        // ================= INSERT PART =================
        Session session = factory.getCurrentSession();
        Transaction tx = session.beginTransaction();

        Employee existing = session.find(Employee.class, 3);

        Employee e = new Employee();
        // e.setID(3);  // ❌ commented because ID is AUTO GENERATED
        e.setFn("Amit");
        e.setLn("Agarwal");
        e.setSal(1.25);
        session.save(e);
        System.out.println("Record inserted");

        Employee e1 = session.find(Employee.class, 3);
        if (e1 != null) {
            System.out.println("Record retrived successfully " + e1.getSal());
        }

        tx.commit();
        session.close();

        // ================= DELETE PART =================
//        Session session2 = factory.openSession();
//        Transaction t2 = session2.beginTransaction();
//        
//        Employee e3 = session2.find(Employee.class, 2);
//      
//        if (e3 != null) {
//            session2.delete(e3);
//            System.out.println("Record Deleted successfully");
//        } else {
//            System.out.println("Record not found, so not deleted");
//        }
//        
//        t2.commit();
//        session2.close();
       factory.close();
    }
}
