package chapter_4_6_2;

import static org.junit.Assert.assertEquals;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Test;

public class DequeTest {
    
    @Test
    public void DequeMethodTest(){
        Deque<Integer> deque = new LinkedList<>();
        
        deque.offerFirst(1);
        deque.offerFirst(3);
        deque.offerLast(5);

        assertEquals("[3, 1, 5]", deque.toString());

        assertEquals((Integer)3, deque.pollFirst());
        assertEquals((Integer)5, deque.pollLast());
        assertEquals("[1]", deque.toString());

    }
}
