package chapter_8_1_1;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class FileTest {
    
    @Test
    public void FileClassTest(){
        File logfile = new File("/Users/sugimotokazuya/Documents/Import.log");
        
        assertEquals("Import.log", logfile.getName());

        
        File dir = new File("/Users/sugimotokazuya/Pictures");
        
        for(String file : dir.list()){
            System.out.println(file);
        }

        assertEquals(4, dir.list().length);
    }

    @Test
    public void PathClassTest(){
        Path path = Paths.get("/Users/sugimotokazuya/Documents/Import.log");

        assertEquals("Import.log", path.getFileName().toString());

        File dir = path.getParent().toFile();

        assertEquals("/Users/sugimotokazuya/Documents", dir.getPath());

        for(String file : dir.list()){
            System.out.println(file);
        }
    }

    @Test
    public void ReadFileTest(){
        File file = new File("/Users/sugimotokazuya/Documents/sample.txt");

        InputStream inputStream = null;

        try{
            inputStream = new FileInputStream(file);
            for (int ch; (ch = inputStream.read()) != -1; ) {
                System.out.println((char)ch);
            }s
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(IOException ex){
            System.out.println(ex.getMessage());
        }finally{
            if(inputStream != null){
                try{

                    inputStream.close();
                }catch(IOException ex){
                    System.out.println(ex.getMessage());
                }
            }
        }


    }

}
