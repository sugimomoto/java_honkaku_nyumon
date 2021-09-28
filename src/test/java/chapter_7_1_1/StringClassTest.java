package chapter_7_1_1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Test
    public void StringIndexOfTest(){
        String sentence = "This is a pen";
        int index = sentence.indexOf("is");

        assertEquals(2, index);

        index = sentence.indexOf("is",3); // be動詞のisの場所を返す
        assertEquals(5, index);

        index = sentence.lastIndexOf("is"); // 末尾から検索する。検索結果の数字は頭からの数
        assertEquals(5, index);

        sentence = "これはペンです。";
        index = sentence.indexOf("ペン");

        assertEquals(3, index);

    }

    @Test
    public void StringPatternMatching(){
        Pattern pattern = Pattern.compile("This is a .*\\.");

        String sentence = "This is a pen.";

        Matcher matcher = pattern.matcher(sentence);
        
        assertTrue("適合する", matcher.matches());
    }

    @Test
    public void StringPattenSplit(){
        Pattern pattern = Pattern.compile("\\s+");

        String sentence = "This   is a pen.";

        String[] words = pattern.split(sentence);

        assertEquals(4, words.length);
        assertEquals("This", words[0]);
        assertEquals("is", words[1]);
        assertEquals("a", words[2]);
        assertEquals("pen.", words[3]);
    }

    @Test
    public void StringPatternReplaceAll(){
        Pattern pattern = Pattern.compile("\\s+");

        String sentence = "This   is a pen.";

        Matcher matcher = pattern.matcher(sentence);

        assertEquals("This is a pen.", matcher.replaceAll(" "));
    }

    @Test
    public void StringMethodRegixTest(){
        String sentence = "This    is a pen.";

        assertTrue("message", sentence.matches("Th.* is a .*\\."));

        String[] words = sentence.split("\\s+");
        assertEquals(4, words.length);

        assertEquals("This is a pen.", sentence.replaceAll("\\s+", " "));

        // String クラスのメソッドの中では、実際には正規表現クラスを利用した処理が行われている
        // それぞれのメソッドを呼び出すたびに、オブジェクトが生成されているので、何回も繰り返し行う場合は、処理パフォーマンスが遅くなってしまう可能性がある
        // 一回だけ処理を行う場合はStringクラスのメソッド
        // 対象の文字列を繰り返し処理する場合は、自分でPatternクラスのオブジェクトを生成するのが望ましい
    }

    @Test
    public void StringFormatTest(){
        int number = 13;
        String parameter = "apples";

        String result = String.format("I have %d %s.", number, parameter);

        assertEquals("I have 13 apples.", result);

        // %X は16進数、%S は大文字
        // https://docs.oracle.com/javase/jp/8/docs/api/java/util/Formatter.html#syntax
        result = String.format("I have %X %S.", number, parameter);

        assertEquals("I have D APPLES.", result);
    }
}
