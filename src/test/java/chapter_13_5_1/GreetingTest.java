package chapter_13_5_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeTrue;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

public class GreetingTest {
    
    @Test
    public void GreetingMethodTest(){

        Greeting greeting = new Greeting();

        assertEquals("おはようございます", greeting.getMessage(5));

        assertEquals("こんにちは", greeting.getMessage(11));

        assertEquals("こんばんは", greeting.getMessage(17));

        // assume 系メソッドはテストの事前確認を行うのに用いる
        // 例えばWindows環境でしか実行できないテストを行う等
        assumeTrue(true);
        
        
    }

    @Test
    public void AssertSample(){
        int a = 10;
        int b = 10;

        assertNotEquals(a, b);
    }

    @Test
    public void AssertThatSample(){
        int a = 10;
        int b = 10;
        int c = 9;

        
        // https://itsakura.com/java-assertthat_method
        // import static org.hamcrest.CoreMatchers.*; を手動で追加する
        // is で同じ値を期待
        assertThat(a, is(b));

        // not で否定
        assertThat(a, is(not(c)));

    }
}
