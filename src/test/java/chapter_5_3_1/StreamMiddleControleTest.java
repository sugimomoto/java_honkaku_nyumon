package chapter_5_3_1;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import chapter_4_1_5.Student;

public class StreamMiddleControleTest {
    
    private Integer actualScore = 0;

    @Test
    public void MapTest(){
        List<Student> students = new ArrayList<>();
        
        students.add(new Student("Hello", 100));
        students.add(new Student("World", 80));
        students.add(new Student("Stream", 50));
        
        Stream<Integer> stream = students.stream().map(s -> s.getScore());
        stream.forEach(score -> actualScore += score);

        assertEquals((Integer)230, actualScore);

        actualScore = 0;
        stream = students.stream().map(Student::getScore);
        stream.forEach(score -> actualScore += score);

        assertEquals((Integer)230, actualScore);

    }
}
