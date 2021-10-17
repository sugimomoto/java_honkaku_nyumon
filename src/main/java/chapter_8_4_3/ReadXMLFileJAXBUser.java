package chapter_8_4_3;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;

import jakarta.xml.bind.Marshaller;

public class ReadXMLFileJAXBUser {
    
    private User user;

    private String xmlFile;

    public ReadXMLFileJAXBUser(String xmlFile){
        this.xmlFile = xmlFile;

    }

    public void parse(){

        try(InputStream is = Files.newInputStream(Paths.get(xmlFile))){
            jakarta.xml.bind.JAXBContext jaxbContext = org.eclipse.persistence.jaxb.JAXBContextFactory
            .createContext(new Class[] {User.class}, null);

            this.user = (User)jaxbContext.createUnmarshaller().unmarshal(is);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public User getUser(){
        return user;
    }
    
}
