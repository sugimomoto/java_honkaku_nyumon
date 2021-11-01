package chapter_10_4_4.DoNotUseStatic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DoNotUseStatic {
    
    @Test
    public void MethodTest(){
        Foo foo = new DefaultFoo("Hello Foo!");
        assertEquals("Hello Foo!", foo.say());

    }
}
