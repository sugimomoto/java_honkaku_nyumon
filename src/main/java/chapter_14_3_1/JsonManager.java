package chapter_14_3_1;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonManager {

    private String path;

    public JsonManager(String filePath){
        path = filePath;
    }

    public Employee readEmployeeFromJson() throws StreamReadException, DatabindException, IOException{
        File file = new File(path);

        ObjectMapper mapper = new ObjectMapper();
        Employee employee = mapper.readValue(file, Employee.class);

        return employee;
    }

    public Map<?,?> readEmployeeFromJsonWithMap() throws StreamReadException, DatabindException, IOException {
        File file = new File(path);

        ObjectMapper mapper = new ObjectMapper();
        Map<?,?> employee = mapper.readValue(file, Map.class);

        return employee;
    } 
}
