package demo;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class AcceptCourseIdDisplayStudent {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Course Id: ");
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

            Course c1 = ses.load(Course.class, id);
            System.out.println("Course Name: "+c1.getCourseName());

            List<Student> studentList = c1.getStudentList();
            System.out.println("======================================================");
            for (Student s : studentList) {
                System.out.println(s.getStudName());

            }

        }
    }

