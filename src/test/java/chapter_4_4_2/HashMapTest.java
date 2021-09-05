package chapter_4_4_2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Test;

public class HashMapTest {
    
    @Test
    public void HashMapMethodTest(){
        HashMap<String,Integer> scores = new HashMap<>();

        scores.put("Ken",100);
        scores.put("Shin",60);
        scores.put("Takuya",80);

        assertEquals("{Ken=100, Shin=60, Takuya=80}", scores.toString());

        scores.put("Shin",50);
        assertEquals("{Ken=100, Shin=50, Takuya=80}", scores.toString());

        assertEquals(((Integer)100), scores.get("Ken"));

        scores.remove("Takuya");
        assertEquals("{Ken=100, Shin=50}", scores.toString());

        assertEquals(2, scores.size());

        assertTrue(scores.containsKey("Ken"));

        assertTrue(scores.containsValue(100));

    }
}
