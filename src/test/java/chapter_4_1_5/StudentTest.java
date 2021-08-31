package chapter_4_1_5;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class StudentTest {
    
    @Test
    public void StudentOrderTest(){
        Student[] students = {
            new Student("kazuya",100),
            new Student("hitomi",105),
            new Student("haru",85)
        };

        Arrays.sort(students);
        
        Student[] expecteds = {
            new Student("hitomi",105),
            new Student("kazuya",100),
            new Student("haru",85)
        };
        
        assertArrayEquals(expecteds, students);
    }
}
