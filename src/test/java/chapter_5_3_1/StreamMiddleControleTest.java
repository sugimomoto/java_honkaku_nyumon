package chapter_5_3_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

    @Test
    public void MiddleProcessingTest(){
        List<Student> students = new ArrayList<>();
        
        students.add(new Student("Hello", 100));
        students.add(new Student("World", 80));
        students.add(new Student("Stream", 50));
        
        students = students.stream().filter(s -> s.getScore() < 90).toList();
        assertEquals(2, students.size());

        students = students.stream().limit(1).toList();
        assertEquals(1, students.size());

        List<String> strings = new ArrayList<>();
        strings.add("Ken");
        strings.add("Shin");
        strings.add("Ken");
        strings.add("Takuya");
        strings.add("Ken");
        strings.add("Shin");

        strings = strings.stream().distinct().toList();

        assertEquals(3, strings.size());
    }

    @Test
    public void StreamEndProcessing(){
        List<String> strings = new ArrayList<>();
        strings.add("Ken");
        strings.add("Shin");
        strings.add("Ken");
        strings.add("Takuya");
        strings.add("Ken");
        strings.add("Shin");

        String result = strings.stream().distinct().collect(Collectors.joining(","));

        assertEquals("Ken,Shin,Takuya", result);

        // 引数を省略することもできる
        result = strings.stream().distinct().collect(Collectors.joining());
        assertEquals("KenShinTakuya", result);

        // Setにすると重複が弾かれる
        Set<String> resultSet = strings.stream().collect(Collectors.toSet());
        assertEquals(3,resultSet.size());

    }

    @Test
    public void StreamGroupByTest(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ken",100));
        students.add(new Student("Shin",60));
        students.add(new Student("Takuya",80));
        students.add(new Student("Taro",100));
        students.add(new Student("Haru",60));

        //　Groupbyを実行した
        Map<Integer,List<Student>> map = students.stream()
            .collect(Collectors.groupingBy(Student::getScore));

        assertEquals(3,map.size());
        assertEquals(2, map.get(100).size());
        assertEquals(1, map.get(80).size());
        assertEquals(2, map.get(60).size());
    }

    @Test
    public void StreamMaxAndMinTest(){
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ken",100));
        students.add(new Student("Shin",60));
        students.add(new Student("Takuya",80));

        Optional fistStudent = students.stream().findFirst();


        // C# だと firstOfDefault だけど、JavaはOptionalに格納することで、似たような挙動を達成するのね
        if(fistStudent.isPresent()){
            Student result = (Student)fistStudent.get();
            assertEquals(100, result.getScore());
            assertEquals("Ken", result.getName());
        }

        // max / min はOptionalを返す。
        // 空を返す可能性があるため
        Optional student = students.stream()
            .max((s1, s2) -> s1.getScore() - s2.getScore());

        // Optional の値存在チェックは isPresentで行うことができる
        if(student.isPresent()){
            Student result = (Student)student.get();
            assertEquals(100, result.getScore());
            assertEquals("Ken", result.getName());
        }

        int maxScore = students.stream().mapToInt(Student::getScore).sum();

        assertEquals(240, maxScore);

        long count = students.stream().mapToInt(Student::getScore).count();

        assertEquals(3, count);

        OptionalDouble optionalAvarage = students.stream().mapToInt(Student::getScore).average();

        double avarage = optionalAvarage.isPresent() ? optionalAvarage.getAsDouble() : 0;

        assertEquals((double)80, avarage,0.0);

        String studentStrings = students.stream().map(s -> s.getName() + ":" + String.valueOf(s.getScore())).collect(Collectors.joining(","));
        
        assertEquals("Ken:100,Shin:60,Takuya:80", studentStrings);

    }

    @Test
    public void StreamAPIPoint(){
        List<String> list = Arrays.asList("Murata","Okada","Tanimoto");

        List<String> newList = list.stream().filter(s -> s.length() > 5)
            .map(s -> "[" + s + "]")
            .collect(Collectors.toList());

        assertEquals(2, newList.size());
        assertEquals("[Murata]", newList.get(0));


        String result = IntStream.range(0, 5)
            .mapToObj(i -> "?")
            .collect(Collectors.joining(","));

        assertEquals("?,?,?,?,?", result);

    }

    @Test
    public void StreamLikeMethodOfListTest(){
        List<String> list = new ArrayList<>();
        list.add("Murata");
        list.add("Okada");
        list.add("Tanimoto");

        list.removeIf(s -> s == "Okada");

        assertEquals(2, list.size());

        list.replaceAll(s -> s.toUpperCase());

        assertEquals("MURATA", list.get(0));
        assertEquals("TANIMOTO", list.get(1));
    }

    @Test
    public void StreamLikeMapMethodTest(){
        List<String> list = new ArrayList<>();
        list.add("Murata");
        list.add("Okada");
        list.add("Tanimoto");
        list.add("Sakamoto");


        HashMap<Integer, List<String>> expectMap = new HashMap<>();
        expectMap.put(5, Arrays.asList("Okada"));
        expectMap.put(6, Arrays.asList("Murata"));
        expectMap.put(8, Arrays.asList("Tanimoto","Sakamoto"));

        HashMap<Integer, List<String>> map = new HashMap<>();

        list.forEach(name -> {
            Integer nameLen = name.length();
            List<String> valueList = map.get(nameLen);

            if(valueList == null){
                valueList = new ArrayList<>();
                map.put(nameLen, valueList);
            }

            valueList.add(name);
        });

        assertEquals(expectMap.toString(), map.toString());

        HashMap<Integer, List<String>> map2 = new HashMap<>();

        list.forEach(name -> {
            Integer nameLen = name.length();
            List<String> valueList = map2.computeIfAbsent(nameLen, key -> 
            new ArrayList<>());
            valueList.add(name);
        });

        assertEquals(expectMap.toString(), map2.toString());


    }
}
