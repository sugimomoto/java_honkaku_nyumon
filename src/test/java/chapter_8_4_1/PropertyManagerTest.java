package chapter_8_4_1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PropertyManagerTest {
    
    @Test
    public void PropertyFileManagerMethodTest(){
        PropertyFileManager propertyFileManager = new PropertyFileManager();

        String mailaddress = propertyFileManager.GetPropertyValue("system.mail.address");

        assertEquals("okada@example.com", mailaddress);

    }
}
