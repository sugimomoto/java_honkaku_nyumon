package chapter_8_1_1;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.CacheRequest;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
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

        // バイナリファイルを読み込む場合のパターン
        File file = new File("/Users/sugimotokazuya/Documents/sample.txt");

        InputStream inputStream = null;

        try{
            inputStream = new FileInputStream(file);
            for (int ch; (ch = inputStream.read()) != -1; ) {
                System.out.println((char)ch);
            }
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

    @Test
    public void ReadTextFileJava6BeforeTest(){
        File file = new File("/Users/sugimotokazuya/Documents/sample.txt");

        BufferedReader reader = null;

        try{
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));

            for (String line; (line = reader.readLine()) != null;) {
                System.out.println(line);
            }
        }catch(UnsupportedEncodingException ex){
            System.out.println("Support されていないエンコーディング");
        }catch(FileNotFoundException ex){
            System.out.println("ファイルが存在しない場合のエラー");
        }catch(IOException ex){
            System.out.println("ファイルの読み取りに失敗した場合のエラー");
        }finally{
            if(reader != null){
                try{
                    reader.close();
                }catch(IOException ex){
                    System.out.println(ex);
                }
            }
        }
    }

    @Test
    public void ReadTextFileJava7AfterTest(){

        // Java7以降はめっちゃ簡単になってるー！
        Path path = Paths.get("/Users/sugimotokazuya/Documents/sample.txt");

        try(BufferedReader reader = Files.newBufferedReader(path,StandardCharsets.UTF_8)){
            for(String line; (line = reader.readLine()) != null;){
                System.out.println(line);
            }
        }catch(IOException ex){
            System.out.println(ex);
        }
    }

}
