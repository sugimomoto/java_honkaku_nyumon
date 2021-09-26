package chapter_7_1_1;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class StringClassTest {
    
    @Test
    public void StringMethodTest(){
        String originalText = "THIS IS TEST!";
        String lowerText = originalText.toLowerCase();

        // String クラスは immutable（不変の）なクラス
        // なので、Methodを呼び出しても、内部の文字列を変更することは無い。
        assertEquals("THIS IS TEST!", originalText);        
        assertEquals("this is test!", lowerText);
    }

    @Test
    public void StringAppendPerformanceTest(){
        int LOOP_COUNT = 100000;

        long startTime;
        long endTime;

        startTime = System.currentTimeMillis();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < LOOP_COUNT; i++) {
            builder.append("a");
        }


        assertEquals(LOOP_COUNT, builder.toString().length());

        endTime = System.currentTimeMillis();
        System.out.println("String builderを利用した場合 : " + (endTime - startTime) + "ms");        

        startTime = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < LOOP_COUNT; i++) {
            str += "a";
        }

        assertEquals(LOOP_COUNT, str.length());
        endTime = System.currentTimeMillis();
        System.out.println("+演算子を利用した場合 : " + (endTime - startTime) + "ms");        

        startTime = System.currentTimeMillis();
        String strconcat = "";

        for (int i = 0; i < LOOP_COUNT; i++) {
            strconcat = strconcat.concat("a");
        }

        assertEquals(LOOP_COUNT,strconcat.length());
        endTime = System.currentTimeMillis();
        System.out.println("Concatを利用した場合 : " + (endTime - startTime) + "ms");        

        System.out.println("String builder を利用するのが一番パフォーマンスが高い");
        System.out.println("繰り返し文字列結合を行う想定の場合は、String builder、局所的な場合は＋演算子のほうが読みやすい");

    }

    @Test
    public void StringSpritTest(){
        String sentence = "This is a pen";
        String[] words = sentence.split(" ");

        for (String word : words) {
            System.out.println(word);
        }

        assertEquals(4, words.length);

        String url = "www.acroquest.co.jp";

        // "."が正規表現に当たるため、バックスラッシュでエスケープさせる必要がある。
        // Mac でバックスラッシュはOptionを押しながら、¥キー
        words = url.split("\\.");

        assertEquals(4, words.length);

        for (String word : words) {
            System.out.println(word);
        }
    }

    @Test
    public void StringJoinTest(){
        List<String> wordList = new ArrayList<>();
        wordList.add("Hello");
        wordList.add("World");
        wordList.add("Java");

        String result = String.join(" ", wordList);

        assertEquals("Hello World Java", result);

        // こういう指定もできる
        String message = String.join(".","www","cdata","com");
        assertEquals("www.cdata.com", message);
        
    }

    @Test
    public void StringReplaceTest(){
        String sentence = "This is a pen";
        String replacedSentence = sentence.replace("a ", "").replace("pen", "pens").replace("This","These").replace("is", "are");

        assertEquals("These are pens", replacedSentence);
    }
}
