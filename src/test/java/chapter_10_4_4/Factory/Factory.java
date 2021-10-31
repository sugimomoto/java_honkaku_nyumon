package chapter_10_4_4.Factory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Factory {
    
    @Test
    public void MethodTest(){

        // Default Foo の実装を意識しなくて済む
        Foo foo = FooFactory.newInstance("Hello Foo!");
        assertEquals("Hello Foo!", foo.say());
    }

}
