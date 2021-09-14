package chapter_5_3_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


import org.junit.Test;

import chapter_4_1_5.Group;
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

    @Test

    public void MapGroupTest(){
        List<Group> groups = new ArrayList<>();

        Group group1 = new Group();
        group1.add(new Student("Murata",100));
        group1.add(new Student("Tanimoto",60));
        group1.add(new Student("Okada",80));
        groups.add(group1);

        Group group2 = new Group();
        group2.add(new Student("Akiba",75));
        group2.add(new Student("Hayakawa",85));
        group2.add(new Student("Sakamoto",95));
        groups.add(group2);

        Group group3 = new Group();
        group3.add(new Student("Kimura", 90));
        group3.add(new Student("Hashimoto", 65));
        group3.add(new Student("Ueda", 700));
        groups.add(group3);

        Stream<List<Student>> mappedStream = groups.stream().map(g -> g.getStudents());
        Stream<Student> flatMappedStream = groups.stream().flatMap(g -> g.getStudents().stream());

        assertEquals(3, mappedStream.count());
        assertEquals(9, flatMappedStream.count());

        List<Student> sortedStudents = groups.stream()
        .flatMap(g -> g.getStudents().stream())
        .sorted((s1, s2) -> s1.getScore() - s2.getScore())
        .toList();

        Student beforeStuden = new Student("first",0);

        for (Student student : sortedStudents) {

            boolean judge = (beforeStuden.getScore() < student.getScore());
            assertTrue(judge);

            beforeStuden = student;
        }
    }
}
