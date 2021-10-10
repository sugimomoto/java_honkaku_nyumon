package chapter_8_1_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.CacheRequest;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
        String result = "";

        try{
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));

            for (String line; (line = reader.readLine()) != null;) {
                result += line;
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

        assertEquals("お世話になっております。CDataの杉本です。これからよろしくおねがいします。", result);
    }

    @Test
    public void ReadTextFileJava7AfterTest(){

        // Java7以降はめっちゃ簡単になってるー！
        Path path = Paths.get("/Users/sugimotokazuya/Documents/sample.txt");
        String result = "";

        try(BufferedReader reader = Files.newBufferedReader(path,StandardCharsets.UTF_8)){
            for(String line; (line = reader.readLine()) != null;){
                result += line;
            }
        }catch(IOException ex){
            System.out.println(ex);
        }

        assertEquals("お世話になっております。CDataの杉本です。これからよろしくおねがいします。", result);

    }

    @Test 
    public void WriteTextFileJava6BeforeTest(){
        File file = new File("/Users/sugimotokazuya/Documents/sample2.txt");

        BufferedWriter writer = null;

        try{
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
            writer.append("test");
            writer.newLine();
            writer.append("test2");
        }catch(UnsupportedEncodingException ex){
            System.out.println(ex);
        }catch(IOException ex){
            System.out.println(ex);
        }finally{
            if(writer != null){
                try{
                    writer.close();
                }catch(IOException ex){
                    System.out.println(ex);
                }
            }
        }

        Path path = Paths.get("/Users/sugimotokazuya/Documents/sample2.txt");

        String result = "";

        try(BufferedReader reader = Files.newBufferedReader(path,StandardCharsets.UTF_8)){
            for(String line; (line = reader.readLine()) != null;){
                result += line;
            }
        }catch(IOException ex){
            System.out.println(ex);
        }

        assertEquals("testtest2", result);


    }

    private String result = "";
    @Test
    public void TextReadStreamAPITest(){
        Path path = Paths.get("/Users/sugimotokazuya/Documents/sample2.txt");

        try(BufferedReader reader = Files.newBufferedReader(path,StandardCharsets.UTF_8)){

            // ラムダ式は内部的に別関数扱いになるので、呼び出し元のLocal変数定義にアクセスできない。なるほど。
            reader.lines().forEach(line -> result += line);
        }catch(IOException ex){
            System.out.println(ex);
        }

        assertEquals("testtest2", result);
    }
    
    @Test
    public void TextReadStreamAPITest2(){
        Path path = Paths.get("/Users/sugimotokazuya/Documents/sample3.txt");
        String checkText = "";

        try(BufferedReader reader = Files.newBufferedReader(path,StandardCharsets.UTF_8)){
            checkText = reader.lines().map(x -> x.split(" ")[0]).distinct().collect(Collectors.joining(",")).toString();
        }catch(IOException ex){
            System.out.println(ex);
        }

        assertEquals("murata,tanimoto,sakamoto,okada", checkText);
    }

    @Test
    public void FileCopyAfterJava7(){

        Path fromFile = Paths.get("/Users/sugimotokazuya/Documents/sample3.txt");
        Path toFile = Paths.get("/Users/sugimotokazuya/Documents/sample4.txt");

        String checkText = "";

        try{
            Files.copy(fromFile, toFile);
        }catch(IOException ex){
            System.err.println(ex);
        }

        try(BufferedReader reader = Files.newBufferedReader(toFile,StandardCharsets.UTF_8)){
            checkText = reader.lines().map(x -> x.split(" ")[0]).distinct().collect(Collectors.joining(",")).toString();
        }catch(IOException ex){
            System.out.println(ex);
        }

        assertEquals("murata,tanimoto,sakamoto,okada", checkText);


        boolean result = false;
        
        try{
            result = Files.deleteIfExists(toFile);
        }catch(DirectoryNotEmptyException ex){
            System.out.println(ex);
        }catch(IOException ex){
            System.out.println(ex);
        }

        assertEquals(result, true);

        try{
            Files.createFile(toFile);
        }catch(IOException ex){
            System.out.println(ex);
        }

        try{
            result = Files.deleteIfExists(toFile);
        }catch(DirectoryNotEmptyException ex){
            System.out.println(ex);
        }catch(IOException ex){
            System.out.println(ex);
        }

        Path createPath = Paths.get("/Users/sugimotokazuya/Documents/NewPath");

        try{
            Files.createDirectory(createPath);
        }catch(IOException ex){
            System.out.println(ex);
        }

        try{
            result = Files.deleteIfExists(createPath);
        }catch(DirectoryNotEmptyException ex){
            System.out.println(ex);
        }catch(IOException ex){
            System.out.println(ex);
        }


    }

    @Test
    public void CreateTempFileTestByFileClass(){
        File directory = new File("/Users/sugimotokazuya/Documents");

        try{
            File tempFile = File.createTempFile("prefix",".tmp",directory);
            
            // プログラム終了時にtempFileを削除する設定を追加
            // ただし、Java VMなどが強制終了した場合などは残ってしまう
            tempFile.deleteOnExit();

            assertTrue("Temp File exist", tempFile.getAbsolutePath().contains(".tmp"));
            
        }catch(IOException ex){
            System.out.println(ex);
        }
    }

    @Test
    public void CreateTempFileTestByPathClass(){
        Path path = Paths.get("/Users/sugimotokazuya/Documents");

        try{
            Path tempPath = Files.createTempDirectory(path, "pre");
            assertTrue("Temp File was created", tempPath.toString().contains("pre"));
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
}
