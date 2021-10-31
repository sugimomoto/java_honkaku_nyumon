package chapter_10_4_4.UseStatic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UseStatic {
    
    @Test
    public void MethodTest(){
        Foo foo = Foo.newInstance("Hello Foo!");
        assertEquals("Hello Foo!", foo.say());
    }
}
