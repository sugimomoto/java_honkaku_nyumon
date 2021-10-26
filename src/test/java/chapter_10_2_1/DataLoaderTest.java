package chapter_10_2_1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class DataLoaderTest {
    
    @Test
    public void DataLoaderMethodTest(){
        SuperDataLoader superDataLoader = new SuperDataLoader("/Users/sugimotokazuya/Documents/Java/java_honkaku_nyumon/sample.txt");

        List<String> lines;

        boolean flg = false;

        try {
            lines = superDataLoader.load();
            assertEquals(3, lines.size());
            flg = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertTrue("message", flg);
    }
}
