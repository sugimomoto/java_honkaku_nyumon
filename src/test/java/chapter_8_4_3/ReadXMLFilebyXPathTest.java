package chapter_8_4_3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReadXMLFilebyXPathTest {
    
    @Test
    public void ReadXMLFilebyXPathClassTest(){
        ReadXMLFileXPath reader = new ReadXMLFileXPath();

        reader.parse("/Users/sugimotokazuya/Documents/Java/java_honkaku_nyumon/staff.xml");

        assertEquals(reader.readXMLbyXPath("/staffs/staff/name/firstname/text()"), "Takuya");        
        assertEquals(reader.readXMLbyXPath("/staffs/staff/@id"), "1");        

    }
}
