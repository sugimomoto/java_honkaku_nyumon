package chapter_4_4_4;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;

import org.junit.Test;

public class LinkedHashMapTest {
    
    @Test
    public void LinkedHashMapMethodTest(){
        LinkedHashMap<Integer,String> map = new LinkedHashMap<>();

        map.put(1, "Hello");
        map.put(2, "World");
        map.put(3, "LinkedHashMap");

        // あまりメソッド関係に大きな違いは無い。
        // 実装されている内部が違うのか。
        assertEquals("{1=Hello, 2=World, 3=LinkedHashMap}", map.toString());

    }
}
