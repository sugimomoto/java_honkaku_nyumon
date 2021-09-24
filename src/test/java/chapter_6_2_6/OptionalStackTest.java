package chapter_6_2_6;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;

public class OptionalStackTest {
    
    @Test
    public void OptionalStackMethodTest(){

        OptionalStack<String> optStack = new OptionalStack<>();

        // まだPushしていないので、値を持たないOptionalを返す
        Optional<String> optional = optStack.pop();
        assertEquals(false, optional.isPresent());

        String optElement = optional.orElse("empty");
        assertEquals("empty", optElement);

        optStack.push("Scala");
        optStack.push("Groovy");
        optStack.push("Java");

        optional = optStack.pop();

        assertEquals(true, optional.isPresent());
        assertEquals("Java", optional.get());

    }
}
