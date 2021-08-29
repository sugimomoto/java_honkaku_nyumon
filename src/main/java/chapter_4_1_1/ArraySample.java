package chapter_4_1_1;

import java.util.Arrays;

public class ArraySample {
    

    public static void arraySample(){
        // 宣言時に内容が決まっていない
        int[] arrya_a = new int[5];
        System.out.println(arrya_a.toString());

        // 宣言時に内応が決まっている
        int[] array_b = {1,1,2,3,5};
        System.out.println(array_b.toString());

        // 宣言後に内容が決まる
        int[] array_c;
        array_c = new int[]{1,1,2,3,5};
        System.out.println(array_c.toString());
    }

    public static void arrayCopySample(){
        int[] array = {1,1,2,3,5};

        int[] newArray = Arrays.copyOf(array, array.length + 3);
        
        System.out.println("array : " + array.length);
        System.out.println("newArray : " + newArray.length);



    }
}
