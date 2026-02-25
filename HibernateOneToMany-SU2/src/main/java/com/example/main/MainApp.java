package com.example.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.example.entity.Department;
import com.example.entity.Employee;
import com.example.util.HibernateUtil;

public class MainApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getFactory().openSession();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Dept Name");
        String deptName = sc.nextLine();
        System.out.println("Enter No of Employees");
        int n = sc.nextInt();
        
        Department dept = new Department();
        dept.setName(deptName);
        
        
        List<Employee> emplist = new ArrayList<Employee>();
        while(n>0) {
          System.out.println("Enter Employee Name");
          String empName = sc.nextLine();
          Employee e = new Employee();
          e.setName(empName);
          e.setDepartment(dept);
          emplist.add(e);
          n--;
        }
//        
//        Employee e1 = new Employee();
//        e1.setName("Krishna");
//
//        Employee e2 = new Employee();
//        e2.setName("Rama");
//        Employee e3 = new Employee();
//        e3.setName("Sandeep");
//
//        e1.setDepartment(dept);
//        e2.setDepartment(dept);
//        e3.setDepartment(dept);

        //dept.setEmployees(List.of(e1,e2));
//       
//        emplist.add(e1);
//        emplist.add(e2);
//        emplist.add(e3);

        dept.setEmployees(emplist);
        

        session.beginTransaction();
        session.persist(dept);
        session.getTransaction().commit();

        session.close();
    }
}