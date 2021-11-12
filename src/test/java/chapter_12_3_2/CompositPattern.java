package chapter_12_3_2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CompositPattern {
    
    @Test
    public void CompositTest(){
        File file1 = new File("File1");
        File file2 = new File("File2");
        File file3 = new File("File3");
        File file4 = new File("File4");

        Directory dir1 = new Directory("dir1");
        dir1.add(file1);

        Directory dir2 = new Directory("dir2");
        dir2.add(file2);
        dir2.add(file3);

        dir1.add(dir2);

        dir1.add(file4);

        assertEquals("Directory [name=dir1,list=[File [name=File1], Directory [name=dir2,list=[File [name=File2], File [name=File3]]], File [name=File4]]]", dir1.toString());
        assertEquals("Directory [name=dir2,list=[File [name=File2], File [name=File3]]]", dir2.toString());

    }
}
