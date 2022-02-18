package chapter_14_3_1;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

public class JsonManager {

    private String path;

    public JsonManager(String filePath){
        path = filePath;
    }

    public Employee readEmployeeFromJson() throws StreamReadException, DatabindException, IOException{
        File file = new File(path);


        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        
        Employee employee = mapper.readValue(file, Employee.class);

        return employee;
    }

    public Map<?,?> readEmployeeFromJsonWithMap() throws StreamReadException, DatabindException, IOException {
        File file = new File(path);

        ObjectMapper mapper = new ObjectMapper();
        Map<?,?> employee = mapper.readValue(file, Map.class);

        return employee;
    } 

    public void createEmployeeJson(Employee employee) throws StreamWriteException, DatabindException, IOException{
        File file = new File(path);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, employee);
    }

    public void createEmployeeJsonWithMap(Map<String,Object> map) throws StreamWriteException, DatabindException, IOException{
        File file = new File(path);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, map);
    }
}
