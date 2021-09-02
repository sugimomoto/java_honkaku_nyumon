package chapter_4_3_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSample {
    
    public static List<Integer> GetNormalList(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        return list;
    }

    public static List<Integer> GetReadOnlyList(){
        // asList メソッドで作成したクラスは通常のArrayListとは異なり
        // 読み取り専用で、Listへの要素の追加、変更、削除ができない。
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        return list;
    }

    public static List<Integer> GetNormalListFromAsList(){
        // asListメソッドを使っても、new して格納していれば、要素の変更に対応できる。
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        return list;
    }
}
