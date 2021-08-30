package chapter_4_1_5;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Assert;
import org.junit.Test;

public class ArraySortTest {
    
    @Test
    public void ArraySimpleSortTest(){
        
        int[] array = ArraysSort.getSortArray(new int[]{1,5,4,7});

        assertArrayEquals(new int[]{1,4,5,7}, array);

        Integer[] arrayDesc = ArraysSort.getDescSortArray(new Integer[]{1,5,4,7});

        assertArrayEquals(new Integer[]{7,5,4,1}, arrayDesc);
    }
}
