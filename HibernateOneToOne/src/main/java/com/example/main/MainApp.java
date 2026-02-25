package com.example.main;

import org.hibernate.Session;
import java.util.Scanner;
import com.example.entity.*;
import com.example.util.HibernateUtil;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Person Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Passport Number: ");
        String passportNo = sc.nextLine();

        Session session = HibernateUtil.getFactory().openSession();

        Person p = new Person();
        p.setName(name);

        Passport pass = new Passport();
        pass.setNumber(passportNo);

        p.setPassport(pass);

        session.beginTransaction();
        session.persist(p);
        session.getTransaction().commit();

        session.close();
        sc.close();

        System.out.println("Data saved successfully!");
    }
}