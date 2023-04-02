package demo;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class AcceptStudIdDisplayCourses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enrter Student Id: ");
        int id = sc.nextInt();

        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Course.class);
        cfg = cfg.addAnnotatedClass(Student.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        Student s1 = ses.load(Student.class, id);
        System.out.println("Student Name: "+s1.getStudName());

        List<Course> courseList = s1.getCourseList();
        System.out.println("======================================================");
        for (Course c : courseList) {
            System.out.println(c.getCourseName());

        }

    }
}
