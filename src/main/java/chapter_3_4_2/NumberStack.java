package chapter_3_4_2;

import java.util.ArrayList;
import java.util.List;

public class NumberStack<E extends Number> {
    private List<E> taskList;

    public NumberStack(){
        taskList = new ArrayList<>();
    }

    public boolean push(E task){
        return taskList.add(task);
    }

    public E pop(){
        if(taskList.isEmpty()){
            return null;
        }

        return taskList.remove(taskList.size() - 1);
    }

    public int sum(){
        int result = 0;

        for (E e : taskList) {
            // Number の子クラスだけを認めているので、intValueメソッドが利用できる
            result = result + e.intValue();
        }

        return result;
    }
}
