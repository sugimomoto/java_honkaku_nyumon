package chapter_14_2_1;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Paths;

import org.supercsv.cellprocessor.*;
import org.supercsv.cellprocessor.constraint.*;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

public class EmployeeReader {

    private Path path;

    public EmployeeReader(String filePath){
        path = Paths.get(filePath);
    }

    public void writeEmployee(List<Employee> employees) {
        String[] header = new String[]{"name","age","birth","email","note"};

        CellProcessor[] processors = new CellProcessor[]{
            new NotNull(),
            new NotNull(),
            new FmtDate("yyyy/MM/dd"),
            new NotNull(),
            new Optional()
        };

        try(ICsvBeanWriter beanWriter = new CsvBeanWriter(Files.newBufferedWriter(path), CsvPreference.STANDARD_PREFERENCE)){
            beanWriter.writeHeader(header);
            for (Employee employee : employees) {
                beanWriter.write(employee, header, processors);
            }
        
        } catch (IOException e) {
            // error handling
        }
    }
    
    public List<Employee> readEmployee(){
        List<Employee> employees = new ArrayList();
        
        CellProcessor[] processors = new CellProcessor[]{
            new NotNull(),
            new ParseInt(new NotNull()),
            new ParseDate("yyyy/MM/dd"),
            new StrRegEx("[a-z0-9\\._]+@[a-z0-9\\.]+"),
            new Optional()
        };

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
