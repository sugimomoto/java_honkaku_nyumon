package chapter_4_3_7;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class LinkedListTest {
    
    @Test
    public void LinkedListMethodTest(){
        LinkedList<String> linkedList = new LinkedList<String>();
         
        linkedList.addFirst("Hello");
        linkedList.addLast("Workd");

        assertEquals(2, linkedList.size());

        assertEquals("Hello", linkedList.pop());

        assertEquals(1, linkedList.size());


    }
}
