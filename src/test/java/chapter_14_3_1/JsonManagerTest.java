package chapter_14_3_1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
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

    @Test
    public void JsonCreateTest() throws StreamWriteException, DatabindException, IOException{
        JsonManager jsonManager = new JsonManager("createsample.json");

        Employee employee = new Employee();
        employee.setName("kazuya");
        employee.setAge(33);
        List<String> licenses = new ArrayList();
        licenses.add("ITパスポート");
        licenses.add("大型2種");

        employee.setLicenses(licenses);

        jsonManager.createEmployeeJson(employee);

        Employee createdEmployee = jsonManager.readEmployeeFromJson();

        assertEquals(employee.getName(), createdEmployee.getName());
        assertEquals(employee.getAge(), createdEmployee.getAge());
        assertEquals(employee.getLicenses(), createdEmployee.getLicenses());

    }

    @Test
    public void JsonCreateWithMapTest() throws StreamWriteException, DatabindException, IOException{
        JsonManager jsonManager = new JsonManager("createsample.json");
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("name","sugimoto");
        map.put("age", 34);
        map.put("licenses", Arrays.asList("基本情報","漢字検定"));

        jsonManager.createEmployeeJsonWithMap(map);

        Map<?,?> resultMap = jsonManager.readEmployeeFromJsonWithMap();
        

        assertEquals(map.get("name"), resultMap.get("name"));
        assertEquals(map.get("age"), resultMap.get("age"));
        assertEquals(map.get("licenses"), resultMap.get("licenses"));
    }
}
