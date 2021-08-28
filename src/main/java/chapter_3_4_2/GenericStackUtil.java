package chapter_3_4_2;

import java.util.List;

public class GenericStackUtil {

    public static <T> GenericStack<T> as(List<T> list){
        GenericStack<T> stack = new GenericStack<>();

        for (T t : list) {
            stack.push(t);
        }
        
        return stack;
    }
    
}
