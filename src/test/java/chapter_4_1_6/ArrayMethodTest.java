package chapter_4_1_6;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArrayMethodTest {
    
    @Test
    public void ArrayMethodTestArgs(){

        // 引数でnewをしなくても良い
        ArrayMethod arrayMethod = new ArrayMethod("Hello", "arg1","arg2","arg3");
        assertEquals("ArrayMethod[message=Hello][scores=arg1,arg2,arg3]",arrayMethod.toString());
    }
}
