package chapter_4_1_5;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSort {
    

    public static int[] getSortArray(int[] array){
        Arrays.sort(array);
        return array;
    }

    public static Integer[] getDescSortArray(Integer[] array){

        Comparator<Integer> c = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };

        Arrays.sort(array,c);
        return array;
    }
}
