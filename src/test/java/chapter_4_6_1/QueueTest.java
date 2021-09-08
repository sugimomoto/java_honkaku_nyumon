package chapter_4_6_1;

import static org.junit.Assert.assertEquals;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import org.junit.Test;

public class QueueTest {
    
    @Test
    public void QueueMethodTest(){

        Queue<Integer> queue = new ArrayBlockingQueue<>(10);
        queue.offer(1);
        queue.offer(3);
        queue.offer(5);

        assertEquals(3, queue.size());
        assertEquals("[1, 3, 5]", queue.toString());
        assertEquals((Integer)1, queue.poll());
        
        queue.offer(7);
        assertEquals("[3, 5, 7]", queue.toString());

        // peek 動詞 ちらっと覗く
        assertEquals((Integer)3, queue.peek());
        assertEquals("[3, 5, 7]", queue.toString());


    }
}
