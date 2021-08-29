package chapter_4_1_1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FibonacciTest {
    
    @Test
    public void FibonacciMethodTest(){
        int[] fibonacchi_0 = Fibonacci.getFibonacci(0);
        int[] fibonacchi_1 = Fibonacci.getFibonacci(1);

        int[] fibonacchi_5 = Fibonacci.getFibonacci(5);

        assertEquals(0, fibonacchi_0.length);
        assertEquals(1, fibonacchi_1.length);
        assertEquals(5, fibonacchi_5.length);

        assertEquals(0, fibonacchi_1[0]);

        assertEquals(0, fibonacchi_5[0]);
        assertEquals(1, fibonacchi_5[1]);
        assertEquals(1, fibonacchi_5[2]);
        assertEquals(2, fibonacchi_5[3]);
        assertEquals(3, fibonacchi_5[4]);
    }
}
