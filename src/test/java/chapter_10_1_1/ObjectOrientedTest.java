package chapter_10_1_1;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class ObjectOrientedTest {
    
    @Test
    public void PrimitevTest(){
        int value = 1;

        // プリミティブ型の値なので、値を渡しても書き換わらない
        int result = callByValue(value);

        assertEquals(1, value);
        assertEquals(2, result);
    }

    @Test
    public void ReferenceTest(){
        Entity entity = new Entity();
        entity.value = 1;

        // 参照を渡しているので、値が書き換わる
        callByReferece(entity);
        assertEquals(2, entity.value);

        // 参照を渡しているが、新しいインスタンスで上書きしているので、参照元は変化しない
        callByReferenceUpdate(entity);
        assertEquals(2, entity.value);
    }

    public int callByValue(int value){
        value++;
        return value;
    }

    public void callByReferece(Entity entity){
        entity.value++;
    }

    public void callByReferenceUpdate(Entity entity){
        entity = new Entity();
        entity.value = 3;
    }

    /*
    筆者のルール
    ・原則として、引数オブジェクトの修正は避ける
    ・戻り値がvoidの場合は、引数オブジェクトを修正してもいい
    ・戻り値がvoid以外の場合は、引数オブジェクトを変更してはならない
    　→戻り値が存在するのに、引数のオブジェクトが変更されるのは想像しにくい
    */

    @Test
    public void ImmutableClassTest(){
        String text1 = "This is an apple";
        String text2 = text1.replace("apple","orange");

        // イミュータブルなので、replaceメソッドを使っても元の値は書き換わらない
        assertEquals("This is an apple", text1);
        assertEquals("This is an orange", text2);

    }

    @Test
    public void MutableClassTest(){
        StringBuilder stringBuilder = new StringBuilder("This is ");
        assertEquals("This is ", stringBuilder.toString());
        

        // オブジェクト自身の値を書き換えるメソッドが一つでも存在すれば、ミュータブルなクラスとみなす
        stringBuilder.append("an apple.");
        assertEquals("This is an apple.", stringBuilder.toString());

        AtomicInteger number = new AtomicInteger(1);
        assertEquals(1, number.get());

        number.incrementAndGet();
        assertEquals(2, number.get());

    }
}
