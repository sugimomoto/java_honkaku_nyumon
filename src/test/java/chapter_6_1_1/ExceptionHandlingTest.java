package chapter_6_1_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import chapter_4_1_5.Student;

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
        Path path = new File("").toPath();
        
        // Java 6 までの書き方
        try{
            is = Files.newInputStream(path);
            is.read(contents);

        }catch(IOException ex){
            assertEquals("class java.io.IOException", ex.getClass().toString());
            isIoException = true;
        }finally{
            if(is != null){
                try{
                    is.close();
                }catch(IOException closeEx){

                }
            }
            assertTrue("Finally OK", isIoException);
        }

        // Java 7 以降
        // java.lang.AutoCloseable インターフェース、 java.io.Closeable インターフェースを実装している場合
        // try の部分で実装クラスを宣言しておくと、ブロック終了時に自動的にクローズしてくれるようになった
        isIoException = false;

        try(InputStream InputStream = Files.newInputStream(path)){
            InputStream.read(contents);
        }catch(IOException ex){
            assertEquals("class java.io.IOException", ex.getClass().toString());
            isIoException = true;
        }
        
        assertTrue("Close OK", isIoException);


        isIoException = false;

        // 複数のインスタンスを定義することもできる
        try(InputStream inputStream = Files.newInputStream(path); OutputStream outputStream = new FileOutputStream("path")){
            inputStream.read(contents);
            outputStream.write(contents);
        }catch(IOException ex){
            assertEquals("class java.io.IOException", ex.getClass().toString());
            isIoException = true;
        }
        
        assertTrue("Close OK", isIoException);

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

    @Test
    public void MultiCatchTest(){

        boolean isErrorOccurred = false;
        try{
            String str = new String();
            Class<?> clazz = Class.forName(str);

            // どのエラーが発生しても、キャッチできる書き方
        }catch(ClassNotFoundException | InstantiationError | IllegalAccessError ex){
            isErrorOccurred = true;
        }

        assertTrue("ErrorOccured OK", isErrorOccurred);

    }

    
    @Test
    public void LogedStackTraceTest(){
        String strValue = "abc";
        boolean isExceptionCheck = false;
        try{
            int intValue = Integer.valueOf(strValue);

        }catch(NumberFormatException ex){
            isExceptionCheck = true;

            // ログ出力を忘れない。
            // メッセージだけでなく、スタックトレースも出力することで、
            // エラーの特定労力を大きく削減できる
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            assertTrue("Find Stack Trace", sw.toString().contains("LogedStackTraceTest"));
        }

        assertTrue("Exception was catched", isExceptionCheck);
    }

    @Test
    public void ContinuedByException(){
        Integer num = null;
        Map<Integer,String> props = new HashMap<>();
        try{
            num = Integer.valueOf("hello");
        }catch(NumberFormatException ex){
            System.out.println("プロパティの読み込みに失敗");
            num = 0;
        }

        if(num < 5){
            assertEquals((Integer)0, num);
        }
    }
}

