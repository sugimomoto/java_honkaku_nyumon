package chapter_3_4_2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GenericStackTest {
    
    @Test
    public void GenericStackMethodTest(){
        GenericStack<String> stack = new GenericStack<>();
        stack.push("Hello");
        stack.push("World");

        assertEquals("World", stack.pop());
        assertEquals("Hello", stack.pop());
        assertEquals(null, stack.pop());
    }

}
