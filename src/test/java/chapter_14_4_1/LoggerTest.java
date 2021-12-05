package chapter_14_4_1;

import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import chapter_14_2_1.Employee;

public class LoggerTest {

    private static final Logger logger = LoggerFactory.getLogger(LoggerTest.class);
    
    @Test
    public void LoggerSampleTest(){
        logger.info("Hello Logger");

        Employee employee = new Employee();
        employee.setName("kazuya");
        employee.setAge(34);
        employee.setEmail("test@example.com");

        logger.debug("employee={}", employee);


        

    }
}
