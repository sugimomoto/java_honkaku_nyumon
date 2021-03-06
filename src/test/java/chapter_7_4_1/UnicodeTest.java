package chapter_7_4_1;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class UnicodeTest {
    
    @Test
    public void UnicodeCheckTest(){
        char c = 'あ';
        String result = String.format("%02x", (int)c);

        assertEquals("3042", result);

        c = 'ね';
        result = String.format("%02x", (int)c);

        assertEquals("306d", result);
    }

    @Test
    public void CharacterCodeTest() throws UnsupportedEncodingException{
        String str = "あいうえお";
        byte[] utf8 = str.getBytes("UTF-8");
        StringBuilder builder = new StringBuilder();

        for (byte b : utf8) {
            builder.append(String.format("%02x",b));
        }
        
        assertEquals("e38182e38184e38186e38188e3818a", builder.toString());
        System.out.println(builder.toString());


        builder = new StringBuilder();

        byte[] utf16 = str.getBytes("UTF-16");
        for (byte b : utf16) {
            builder.append(String.format("%02x",b));
        }

        // 先頭のftff は符号化方式。これはビッグエンディアン
        assertEquals("feff3042304430463048304a", builder.toString());
        System.out.println(builder.toString());

        builder = new StringBuilder();

        byte[] utf32 = str.getBytes("UTF-32");
        for (byte b : utf32) {
            builder.append(String.format("%02x",b));
        }

        assertEquals("000030420000304400003046000030480000304a", builder.toString());
        System.out.println(builder.toString());

        builder = new StringBuilder();

        byte[] ms932 = str.getBytes("MS932");
        for (byte b : ms932) {
            builder.append(String.format("%02x",b));
        }

        assertEquals("82a082a282a482a682a8", builder.toString());
        System.out.println(builder.toString());


    }

    @Test
    public void GetCharactorFromCodeTest() throws UnsupportedEncodingException{
        byte[] utf16 = { 0x30, 0x42, 0x30, 0x44};

        assertEquals("あい", new String(utf16,"UTF-16"));

        byte[] ms932 = { (byte)0x82, (byte)0xA0, (byte)0x82,(byte)0xA2 };

        assertEquals("あい", new String(ms932,"MS932"));
    }

    @Test 
    public void SurrogatePairTest(){

        String str = "あ會會淺あ";

        char[] chars = str.toCharArray();
   
        for (char c : chars) {
            if(Character.isLowSurrogate(c) || Character.isHighSurrogate(c)){
                System.out.println("サロゲートペアが含まれる : " + c);
            }else{
                System.out.println("サロゲートペアが含まれる : " + c);
            }
        }

        assertEquals(5, str.length());
        assertEquals(5, str.codePointCount(0, str.length()));

    }

    @Test
    public void StringInternMethodTest(){
        String aaa = "aaa";
        String aa = "aa";
        String a = "a";

        // equals で値の同等性を確認している
        assertEquals(true, aaa.equals(aa + a));

        // 同一オブジェクトではないため、falseになる
        assertEquals(false, (aaa == (aa + a)));

        // intern メソッドでStringオブジェクトの同一オブジェクトを探してくるため、trueとなる
        assertEquals(true, (aaa == (aa + a).intern()));


    }


}
