package chapter_11_2_2;

import java.util.HashMap;
import java.util.Map;

public class BadPractice {
    private Map<String, String> map = new HashMap<>();

    public void doSomething(String value){
        map.put("foo", value);
        doInternal();
    }

    private void doInternal() {
        System.out.println(map.get("foo"));
    }
}
