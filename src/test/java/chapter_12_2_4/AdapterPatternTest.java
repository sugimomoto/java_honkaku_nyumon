package chapter_12_2_4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AdapterPatternTest {
    
    @Test
    public void AdapterTest(){
        Target target = new Adapter();

        assertEquals("New process called old process : HELLO_OLD_PROCESS", target.process());
    }
}
