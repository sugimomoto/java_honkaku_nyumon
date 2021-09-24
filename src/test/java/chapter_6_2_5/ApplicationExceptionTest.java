package chapter_6_2_5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ApplicationExceptionTest {

    @Test
    public void ApplicationExceptionHandleTest(){

        boolean isException = false;

        try{
            ExceptionSampleMethod();
        }catch(ApplicationException ex){
            isException = true;
            assertEquals("ERROR CODE", ex.getId());
        }

        assertTrue("Occurred Application Exception",isException);

    }

    public void ExceptionSampleMethod() throws ApplicationException{
        throw new ApplicationException("ERROR CODE",1,2,3);
    } 
}
