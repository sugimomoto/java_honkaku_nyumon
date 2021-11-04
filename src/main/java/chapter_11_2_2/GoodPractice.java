package chapter_11_2_2;

import java.util.HashMap;
import java.util.Map;

public class GoodPractice {

    // インスタンス変数を持たないので、ステートレスになる。
    // スレッドセーフなプログラムにするなら、最もかんたんな方法。
    // もちろん、どうしてもインスタンス変数を持たせなければならない場合も多いが、不必要にクラス変数やインスタンス変数を使わないように習慣づけておくことが大事。
    public void doSomething(String value){
        Map<String, String> map = new HashMap();
        map.put("foo", value);

        doInternal(map);
    }

    private void doInternal(Map<String, String> map) {
        System.out.println(map.get("foo"));
    }
}
