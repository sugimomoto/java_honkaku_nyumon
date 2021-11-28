package chapter_14_2_1;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class CsvReaderTest {
    
    @Test
    public void EmployeeReaderTest(){
        EmployeeReader reader = new EmployeeReader();

        List<Employee> employees = reader.readEmployee();

        assertEquals(2, employees.size());
        assertEquals("山田 太郎", employees.get(1).getName());
    }
}
