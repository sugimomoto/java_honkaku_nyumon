package chapter_14_2_1;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CsvReaderTest {
    
    @Test
    public void EmployeeReaderTest(){
        EmployeeReader reader = new EmployeeReader("employee.csv");

        List<Employee> employees = reader.readEmployee();

        assertEquals(2, employees.size());
        assertEquals("山田 太郎", employees.get(0).getName());
        assertEquals((Integer)28, employees.get(1).getAge());
        assertEquals(Date.valueOf("1978-4-1"), employees.get(0).getBirth());
        assertEquals(null, employees.get(1).getNote());
    }

    @Test
    public void WriteEmployeeTest(){
        EmployeeReader reader = new EmployeeReader("employeeWrite.csv");

        List<Employee> employees = new ArrayList<>();
        
        Employee employee1 = new Employee();
        employee1.setName("hello");
        employee1.setAge(33);
        employee1.setBirth(Date.valueOf("2021-11-11"));
        employee1.setEmail("sugimomoto@example.com");
        employee1.setNote("note");

        employees.add(employee1);

        Employee employee2 = new Employee();
        employee2.setName("hello2");
        employee2.setAge(34);
        employee2.setBirth(Date.valueOf("2021-11-12"));
        employee2.setEmail("sugimomoto2@example.com");
        employee2.setNote("note2");

        employees.add(employee2);

        reader.writeEmployee(employees);

        employees = reader.readEmployee();
        assertEquals(2, employees.size());

    }

    @Test
    public void ReferenceTest(){
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        employee.setName("hello1");

        employees.add(employee);

        assertEquals("hello1", employees.get(0).getName());

        employee = new Employee();
        employee.setName("hello2");

        employees.add(employee);

        assertEquals(2, employees.size());
        assertEquals("hello1", employees.get(0).getName());
        assertEquals("hello2", employees.get(1).getName());
    }
}
