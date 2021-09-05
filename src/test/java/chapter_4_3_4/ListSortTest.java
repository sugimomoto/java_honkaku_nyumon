package chapter_4_3_4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListSortTest {
    
    @Test
    public void ListSortCheck(){

        List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(1);
        ListSort listSort = new ListSort(list);

        List<Integer> expectAscList = new ArrayList<Integer>();
        expectAscList.add(1);
        expectAscList.add(3);
        expectAscList.add(5);
        expectAscList.add(7);

        List<Integer> expectDescList = new ArrayList<Integer>();
        expectDescList.add(7);
        expectDescList.add(5);
        expectDescList.add(3);
        expectDescList.add(1);

        listSort.AscSort();

        assertArrayEquals(expectAscList.toArray(), listSort.GetList().toArray());

        listSort.DescSort();

        assertArrayEquals(expectDescList.toArray(), listSort.GetList().toArray());

    }

    @Test
    public void ListSearchTest(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(1);
        ListSort listSort = new ListSort(list);

        Integer expectIndex = 3;
        Integer key = 7;

        // Sort していないので一致しない
        assertNotEquals(expectIndex, listSort.SearchList(key));

        listSort.AscSort();

        // Sortしたあとなので一致する。
        assertEquals(expectIndex, listSort.SearchList(key));

    }

    @Test
    public void ListIteratorRemove(){

        List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(1);
        ListSort listSort = new ListSort(list);

        // 4以下の値を削除
        listSort.RemoveThanValue(4);

        assertEquals("5,7", listSort.toString());
    }

}
