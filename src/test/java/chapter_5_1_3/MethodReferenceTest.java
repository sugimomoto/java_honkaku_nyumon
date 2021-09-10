package chapter_5_1_3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class MethodReferenceTest {
    
    @Test
    public void MethodReference(){
        List<Boolean> list = Arrays.asList(true,true);
        // メソッド参照 StaticMethodの場合は{クラス名}::{メソッド名}で参照できる 
        list.forEach(Assert::assertTrue);

        // メソッド参照 自分自身のインスタンスメソッドの場合は  this::{メソッド名} で参照できる
        // この場合、引数名などが省略できてスッキリとした指定になる
        List<String> listStr = Arrays.asList("Hello","World","MethodReference");
        listStr.forEach(this::CheckEmpty);
    }

    public void CheckEmpty(String str){
        assertNotEquals("", str);
    }
}
