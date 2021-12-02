package chapter_14_3_1;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import org.junit.Test;

import junit.framework.AssertionFailedError;

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

    @Test
    public void JsonReadWithMapTest() throws StreamReadException, DatabindException, IOException{
        JsonManager jsonManager = new JsonManager("sample.json");

        Map<?,?> employee = jsonManager.readEmployeeFromJsonWithMap();

        assertEquals("山田 太郎", employee.get("name"));
        assertEquals((Integer)35, employee.get("age"));
        assertEquals(2, ((List<?>)employee.get("licenses")).size());
        assertEquals("第1種運転免許", ((List<?>)employee.get("licenses")).get(0));
    
    }
}
