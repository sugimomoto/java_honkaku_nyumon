package chapter_14_3_1;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class JsonManagerTest {
    
    @Test
    public void JsonReadTest(){
        JsonManager jsonManager = new JsonManager("sample.json");

        Employee employee = new Employee();

        try {
            employee = jsonManager.readEmployeeFromJson();
        } catch (IOException e) {
            //TODO: handle exception
        }

        assertEquals("山田 太郎", employee.getName());
        assertEquals((Integer)35, employee.getAge());
        assertEquals(2, employee.getLicenses().size());
        assertEquals("第1種運転免許", employee.getLicenses().get(0));
    }
}
