package chapter_4_3_4;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

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

    // 予めSortしておかないと検索できない。
    public Integer SearchList(Integer key){
        return Collections.binarySearch(list, key);
    }

    public void RemoveThanValue(Integer key){
        // Iterator を使うと for を使っていても要素が削除できる。
        for(Iterator<Integer> iterator = list.iterator(); iterator.hasNext();){
            Integer integer = iterator.next();
            if(integer < key){
                iterator.remove();
            }
        }
    }

    @Override
    public String toString(){
        String str = "";

        for (Integer integer : list) {
            str = str.isEmpty() ? integer.toString() : str + "," + integer.toString();
        }

        return str;
    }

}
