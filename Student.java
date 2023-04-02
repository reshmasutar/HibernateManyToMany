package domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "stud_id")
    private int studId;

    @Column(name = "stud_name")
    private String studName;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_ref"),
            inverseJoinColumns = @JoinColumn(name = "course_ref")
    )

    private List<Course> courseList;

    public void addCourses(Course courseRef){
        if(courseList==null){
            courseList=new LinkedList<>();
        }
        courseList.add(courseRef);
    }

    public int getStudId() {
        return studId;
    }

    public void setStudId(int studId) {
        this.studId = studId;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
