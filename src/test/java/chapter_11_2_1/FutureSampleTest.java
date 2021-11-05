package chapter_11_2_1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import chapter_11_2_2.FutureSample;

public class FutureSampleTest {
    
    @Test
    public void FutureSampleMethodTest(){
        FutureSample future = new FutureSample();

        assertEquals("Finished.", future.doSomthing());

    }
}
