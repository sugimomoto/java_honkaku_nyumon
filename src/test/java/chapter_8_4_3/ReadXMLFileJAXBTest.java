package chapter_8_4_3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReadXMLFileJAXBTest {
    

    /*
    以下の依存関係の解決が必要だったみたい。
    https://stackoverflow.com/questions/58009038/eclipse-4-12-java-lang-classnotfoundexception-com-sun-xml-internal-bind-v2-co
    */

    /*
    @Test
    public void ReadXmlFileTest(){

        
        String path = "/Users/sugimotokazuya/Documents/Java/java_honkaku_nyumon/staff.xml";
        ReadXMLFileJAXB jaxb = new ReadXMLFileJAXB(path);

        jaxb.parse();

        Staffs staffs = jaxb.getStaffs();

        assertEquals(1, staffs.getStaffList().get(0).getId());

    }


    @Test
    public void ReadXmlFileUserTest(){

        
        String path = "/Users/sugimotokazuya/Documents/Java/java_honkaku_nyumon/user.xml";
        ReadXMLFileJAXBUser jaxb = new ReadXMLFileJAXBUser(path);

        jaxb.parse();

        User user = jaxb.getUser();
        assertEquals("hello", user.getName());

    }
    */
}
