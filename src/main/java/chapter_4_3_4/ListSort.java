package chapter_4_3_4;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSort {

    private List<Integer> list;

    public ListSort(List<Integer> list){
        this.list = list;
    }

    public List<Integer> GetList(){
        return list;
    }

    // Collections.sortのInteger デフォルトはASCソート
    public void AscSort(){
        Collections.sort(list);
    }


    // Des sortにしたい場合は「Comparator」を使う。
    public void DescSort(){

        Comparator<Integer> c = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2.compareTo(o1);
            } 
        };

        Collections.sort(list,c);

    }
}
