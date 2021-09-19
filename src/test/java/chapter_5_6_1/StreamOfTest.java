package chapter_5_6_1;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamOfTest {
    
    @Test
    public void StreamOfCreateListTest(){

        // boxed() で IntStream から Stream<Integer> に変換
        List<Integer> integerList = IntStream.of(1,62,31,1,54,31)
        .boxed().collect(Collectors.toList());

        assertEquals(6, integerList.size());

        // stream() で Stream<Integer> に変換し、 mapToInt で IntStream　に変換。
        int sum = integerList.stream().mapToInt(s -> s.intValue()).sum();

        assertEquals(180, sum);

        List<String> stringList = Stream.of("Takuya","Shin","Satoshi").collect(Collectors.toList());
        
        assertEquals(3, stringList.size());
    }

    @Test
    public void StreamRangeCreateListTest(){
        List<Integer> integerList = IntStream.range(1,11).boxed().collect(Collectors.toList());

        assertEquals(10, integerList.size());

        int sum = integerList.stream().mapToInt(s -> s.intValue()).sum();

        assertEquals(55, sum);


        Integer[] integerArray = IntStream.of(1,62,31,1,54,31).boxed().toArray(s -> new Integer[s]);

        assertEquals(6, integerArray.length);
    }
}
