package chapter_11_1_4;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DeadLockTest {
    
    @Test
    public void DeadLock(){
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.add("list1-1");
        list2.add("list2-1");

        new Thread(new ResourceLoker("スレッドA", list1, list2)).start();
        new Thread(new ResourceLoker("スレッドB", list2, list1)).start();

    }

}
