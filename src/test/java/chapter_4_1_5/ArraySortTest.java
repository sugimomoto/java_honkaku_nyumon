package chapter_4_1_5;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;

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

    @Test
    public void ArraySearch(){
        int[] array1 = {1,1,4,5,7,8,11,12,17,21,24};
        // 見つかった要素の場所を返す
        assertEquals(4, Arrays.binarySearch(array1, 7));

        // 要素が見つからなかった場合、要素が入るであろう場所の値にマイナス符号をつけて、値を1引いた数を返す
        assertEquals(-5, Arrays.binarySearch(array1, 6));

        int[] array2 = {4,1,5,8};
        // 並び替えが行われていない場合は、正しい結果を返さない
        assertNotEquals(3, Arrays.binarySearch(array2, 5));

        // 並び替えを行うと一致する
        Arrays.sort(array2);
        assertEquals(2, Arrays.binarySearch(array2, 5));

    }
}
