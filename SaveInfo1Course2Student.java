package demo;

import domain.Course;
import domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveInfo1Course2Student {
    public static void main(String[] args) {

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg = new Configuration();
        cfg = cfg.configure();
        cfg = cfg.addAnnotatedClass(Student.class);
        cfg = cfg.addAnnotatedClass(Course.class);
        factory = cfg.buildSessionFactory();
        ses = factory.openSession();

        //create object of course
        Course c1 = new Course();
        c1.setCourseName("Java");

        //create object of Student
        Student s1 = new Student();
        s1.setStudName("Reshma");

        Student s2 = new Student();
        s2.setStudName("Payal");

        //add students to course
        c1.addStudents(s1);
        c1.addStudents(s2);

        //save objects
        tx=ses.beginTransaction();
        ses.save(c1);
        ses.save(s1);
        ses.save(s2);
        tx.commit();
        System.out.println("STUDENT AND COURSES ADDED SUCCESSFULLY");


    }
}
