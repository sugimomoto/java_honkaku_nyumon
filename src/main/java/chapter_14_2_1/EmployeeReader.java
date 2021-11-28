package chapter_14_2_1;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

import org.supercsv.cellprocessor.*;
import org.supercsv.cellprocessor.constraint.*;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

public class EmployeeReader {
    
    public List<Employee> readEmployee(){
        List<Employee> employees = new ArrayList();
        
        CellProcessor[] processors = new CellProcessor[]{
            new NotNull(),
            new ParseInt(new NotNull()),
            new ParseDate("yyyy/MM/dd"),
            new StrRegEx("[a-z0-9\\._]+@[a-z0-9\\.]+"),
            new Optional()
        };

        Path path = Paths.get("employee.csv");

        try(ICsvBeanReader beanReader = new CsvBeanReader(Files.newBufferedReader(path), CsvPreference.STANDARD_PREFERENCE)){
            String[] header = beanReader.getHeader(true);
            Employee employee;
            while((employee = beanReader.read(Employee.class, header, processors)) != null){
                employees.add(employee);
            }            
        
        } catch (IOException e) {
            // error handling
        }
        
        return employees;
    }

}
