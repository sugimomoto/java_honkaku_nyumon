package chapter_6_1_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;

import org.junit.Test;

public class ExceptionHandlingTest {
    
    @Test
    public void ExceptionTest(){


        /*
        java.lang.Exception Class
        必ずTry−Catchで補足する必要がある例外クラス
        検査例外と呼ばれる
        */

        byte[] contents = new byte[100];
        InputStream is = null;
        boolean isIoException = false;
        
        try{
            Path path = new File("").toPath();
            is = Files.newInputStream(path);
            is.read(contents);

        }catch(IOException ex){
            assertEquals("class java.io.IOException", ex.getClass().toString());
            isIoException = true;
        }finally{
            
            assertTrue("Finally OK", isIoException);
        }

        /*
        java.lang.RuntimeException Class
        実行時例外を表すクラス
        無理にキャッチする必要は無い。
        */

        Integer result = Integer.parseInt("1");

        /*
        java.lang.Error Class
        通常のアプリケーションでは補足すべきではない、重大な問題を示すクラス
        例えば、java.lang.OutOfMemoryError などが当たる
        */

    }
}
