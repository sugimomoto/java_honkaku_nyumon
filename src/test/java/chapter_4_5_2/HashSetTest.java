package chapter_4_5_2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class HashSetTest {
    
    @Test
    public void HashSetMethodTest(){

        // 値集合を扱う。値が入っているか、サイズはいくつかなどのチェック。重複は登録できない。
        // 値を取得することはできない。
        Set<String> names = new HashSet<>();

        names.add("Hello");
        names.add("World");
        names.add("World"); // 同じ値の追加は無視される
        names.add("HashSet");

        assertEquals("[Hello, World, HashSet]", names.toString());

        names.remove("World");

        assertEquals(2, names.size());

        assertTrue(names.contains("Hello"));
    }
}
