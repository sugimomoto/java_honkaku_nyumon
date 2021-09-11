package chapter_5_2_1;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.*;

import org.junit.Test;

public class StreamTest {
    
    private String actual = "";

    @Test
    public void StreamCreateTest(){
        List<String> list = Arrays.asList("Hello","World","Stream");
        Stream<String> stream = list.stream();

        stream.forEach(x -> {
            actual = actual + x;
        });

        assertEquals("HelloWorldStream", actual);
    }

    @Test
    public void StreamCreateFromArrays(){
        // 配列から作る場合は Arrays.stream で変換できる
        String[] array = {"Hello","World","Stream"};
        Stream<String> stream = Arrays.stream(array);

        stream.forEach(x -> {
            actual = actual + x;
        });

        assertEquals("HelloWorldStream", actual);
    }

    @Test
    public void StreamCreateDirectFromStream(){
        // 値が最初から決まっている場合は、Stream.of で作成することもできる。
        Stream<String> stream = Stream.of("Hello","World","Stream");
        stream.forEach(x -> {
            actual = actual + x;
        });
        assertEquals("HelloWorldStream", actual);
    }

    @Test
    public void StreamCreateFromMap(){
        Map<String,String> map = new HashMap<>();
        map.put("1","Hello");
        map.put("2", "World");
        map.put("3", "Stream");

        // Map は Stream に直接変換できないので、一回entrySetにする
        Stream<Entry<String, String>> stream = map.entrySet().stream();

        stream.forEach(x -> {
            actual = actual + x.getValue();
        });
        assertEquals("HelloWorldStream", actual);
    }

    @Test
    public void IntStreamCreate(){
        // 数値範囲からStreamを生成することもできる
        IntStream stream = IntStream.range(1, 5);

        stream.forEach(x -> {
            actual = actual + x;
        });
        assertEquals("1234", actual);
    }

    @Test
    public void IntStreamCreateClosed(){
        // rangeClosed は末尾も含む
        IntStream stream = IntStream.rangeClosed(1, 5);

        stream.forEach(x -> {
            actual = actual + x;
        });
        assertEquals("12345", actual);
    }

}
