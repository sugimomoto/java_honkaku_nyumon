package chapter_11_2_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class IntIncrementTest {
    
    @Test
    public void IntIncrementThreadTest(){
        IntHolder holder = new IntHolder();
        Thread th1 = new Thread(new IntIncrementer("thread-1", holder));
        Thread th2 = new Thread(new IntIncrementer("thread-2", holder));

        th1.start();
        th2.start();

        try{
            th1.join();
            th2.join();

            System.out.println(holder.getResult());

            assertEquals(2000000, holder.getResult());


        }catch(InterruptedException ex){
            System.out.println(ex);
        }
    }
}
