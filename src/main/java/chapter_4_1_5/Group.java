package chapter_4_1_5;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private List<Student> students;

    public Group(){
        students = new ArrayList<Student>();
    }
    
    public void add(Student student){
        students.add(student);
    }

    public List<Student> getStudents(){
        return students;
    }
}
