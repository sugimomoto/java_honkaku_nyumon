package chapter_8_4_3;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class ReadXMLFileXPath {

    private XPath xpath;
    private Document document;
    
    public void parse(String xmlFile){
        try(InputStream is = Files.newInputStream(Paths.get(xmlFile))){
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = builder.parse(is);
            XPathFactory factory = XPathFactory.newInstance();
            xpath = factory.newXPath();
        }catch(ParserConfigurationException | SAXException | IOException ex){
            System.out.println(ex);
		}
    }

    public String readXMLbyXPath(String path){
        String result = "";

        try{
            result = xpath.evaluate(path, document).toString();
        }catch(XPathExpressionException ex){
            result = null;
        }

        return result;
    }
}
