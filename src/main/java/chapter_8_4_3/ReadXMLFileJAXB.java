package chapter_8_4_3;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;

import jakarta.xml.bind.Marshaller;

public class ReadXMLFileJAXB {
    
    private Staffs staffs;

    private String xmlFile;

    public ReadXMLFileJAXB(String xmlFile){
        this.xmlFile = xmlFile;

    }

    public void parse(){

        try(InputStream is = Files.newInputStream(Paths.get(xmlFile))){
            this.staffs = JAXB.unmarshal(is, Staffs.class);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public Staffs getStaffs(){
        return staffs;
    }
    
}
