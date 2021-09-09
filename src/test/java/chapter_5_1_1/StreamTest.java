package chapter_5_1_1;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import chapter_4_1_5.Student;

public class StreamTest {
    
    @Test
    public void StreamMethodTest(){
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Kazuya",100));
        students.add(new Student("Taro", 70));
        students.add(new Student("Takuya",50));

        assertEquals("[Student [score=100,name=Kazuya], Student [score=70,name=Taro], Student [score=50,name=Takuya]]", students.toString());

        // ラムダ式で並び替え
        Collections.sort(students,(student1, student2) -> Integer.compare(student1.getScore(), student2.getScore()));

        assertEquals("[Student [score=50,name=Takuya], Student [score=70,name=Taro], Student [score=100,name=Kazuya]]", students.toString());

        List<Student> results = students.stream().filter(s -> s.getScore() >= 70).toList();
        assertEquals(2, results.size());

        
        
    }
}
