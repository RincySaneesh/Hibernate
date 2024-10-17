package org.example.entity;
import org.example.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;
import jakarta.persistence.Query;

public class CustomerService {
    private SessionFactory sessionFactory;
    Scanner sc = new Scanner(System.in);

    public CustomerService() {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }


    public void customerRegistration() {
        System.out.println("Enter Your Name:");
        String name = sc.nextLine();
        System.out.println("Enter Your Username:");
        String username = sc.nextLine();
        System.out.println("Enter Your Password:");
        String password = sc.nextLine();

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Customer customer = new Customer();
        customer.setName(name);
        customer.setUserName(username);
        customer.setPassword(password);

        session.save(customer);
        tx.commit();
        session.close();

        System.out.println("You are Registered Successfully!!!");
    }

    public void loginCustomer() {
        System.out.println("Enter Your UserName:");
        String username = sc.nextLine();
        System.out.println("Enter Your Password:");
        String password = sc.nextLine();

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        String hql = "FROM Customer WHERE username = :username AND password = :password";
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        query.setParameter("password", password);

        // Check if user exists
        if (!query.getResultList().isEmpty()) {
            Customer customer = (Customer) query.getResultList().get(0);
            System.out.println("Welcome " + customer.getName());
        } else {
            System.out.println("Sorry, invalid credentials or you are not registered!");
        }

        tx.commit();
        session.close();
    }
}