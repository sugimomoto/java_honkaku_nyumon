package chapter_3_4_2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void GenericStackUtilTest(){
        List<String> list = new ArrayList<>();

        list.add("Java");
        list.add("Groovy");

        GenericStack<String> stack = GenericStackUtil.as(list);

        assertEquals("Groovy", stack.pop());
        assertEquals("Java", stack.pop());
        assertEquals(null, stack.pop());
    }

    @Test
    public void NumberStackTest(){
        NumberStack<Integer> intStack = new NumberStack<>();

        intStack.push(3);
        intStack.push(5);

        assertEquals(8, intStack.sum());

        assertEquals(5, intStack.pop().intValue());
        assertEquals(3, intStack.pop().intValue());
        assertEquals(null, intStack.pop());

        assertEquals(0, intStack.sum());
    }
}
