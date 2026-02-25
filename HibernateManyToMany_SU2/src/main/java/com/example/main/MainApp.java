package com.example.main;

import org.hibernate.Session;
import java.util.*;
import com.example.entity.*;
import com.example.util.HibernateUtil;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Session session = HibernateUtil.getFactory().openSession();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        List<Student> students = new ArrayList<>();

        for(int i=0; i<n; i++) {

            Student student = new Student();

            System.out.print("Enter student name: ");
            student.setName(sc.nextLine());

            System.out.print("Enter number of courses for this student: ");
            int c = sc.nextInt();
            sc.nextLine();

            List<Course> courseList = new ArrayList<>();

            for(int j=0; j<c; j++) {
                Course course = new Course();
                System.out.print("Enter course title: ");
                course.setTitle(sc.nextLine());
                courseList.add(course);
            }

            student.setCourses(courseList);
            students.add(student);
        }

        session.beginTransaction();

        for(Student s : students){
            session.persist(s);
        }

        session.getTransaction().commit();
        session.close();
        sc.close();

        System.out.println("Data saved successfully!");
    }
}