package chapter_13_5_1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GreetingTest {
    
    @Test
    public void GreetingMethodTest(){

        Greeting greeting = new Greeting();

        assertEquals("おはようございます", greeting.getMessage(5));

        assertEquals("こんにちは", greeting.getMessage(11));

        assertEquals("こんばんは", greeting.getMessage(17));
        
    }
}
