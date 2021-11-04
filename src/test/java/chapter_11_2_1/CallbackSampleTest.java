package chapter_11_2_1;

import org.junit.Test;

import chapter_11_2_2.CallbackSample;

public class CallbackSampleTest {
    
    @Test
    public void CallbackSampleMethodTest() throws InterruptedException{
        CallbackSample callback = new CallbackSample();

        callback.doSomething();
        
        Thread.sleep(2000L);
    }
}
