package chapter_8_4_3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReadXMLFileJAXBTest {
    
    @Test
    public void ReadXmlFileTest(){

        String path = "/Users/sugimotokazuya/Documents/Java/java_honkaku_nyumon/staff.xml";
        ReadXMLFileJAXB jaxb = new ReadXMLFileJAXB(path);

        jaxb.parse();

        Staffs staffs = jaxb.getStaffs();

        assertEquals(1, staffs.getStaffList().get(1).getId());

    }
}
