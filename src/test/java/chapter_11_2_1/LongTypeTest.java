package chapter_11_2_1;

import org.junit.Test;

public class LongTypeTest {
    
    @Test
    public void LongPlusMinusTest(){
        LongHolder holder = new LongHolder();
        Thread th1 = new Thread(new LongPlusSetter("thread-1", holder));
        Thread th2 = new Thread(new LongPlusSetter("thread-2", holder));

        th1.start();
        th2.start();

        try{
            th1.join();
            th2.join();
            long result = holder.getResult();
            System.out.println("result: " + result);
        }catch(InterruptedException ex){
            System.out.println(ex);
        }
    }
}
