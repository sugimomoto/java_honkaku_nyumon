package chapter_3_4_2;

import java.util.ArrayList;
import java.util.List;

public class GenericsSample {
    

    public GenericsSample(){

    }

    public void Call(){
        List<String> list = new ArrayList<>();
        
        list.add("Hello");
        list.add("World");

        String element = list.get(0);

        System.out.println(element);


    }
}
