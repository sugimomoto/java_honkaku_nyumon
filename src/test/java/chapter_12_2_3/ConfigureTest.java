package chapter_12_2_3;

import static org.junit.Assert.assertEquals;

import org.eclipse.persistence.internal.core.helper.CoreField;
import org.junit.Test;

public class ConfigureTest {
    
    // https://debimate.jp/2020/04/26/%E3%80%90singelton%E3%83%91%E3%82%BF%E3%83%BC%E3%83%B3%E3%80%91%E8%80%83%E3%81%88%E6%96%B9%E3%81%AF%E5%8D%98%E7%B4%94%E3%81%A0%E3%81%8C%E3%80%81%E4%BD%BF%E3%81%84%E3%81%A9%E3%81%93%E3%82%8D%E3%81%8C/
    @Test
    public void ConfigureInstanceTest(){

        Configure config = Configure.getInstance();

        config.increment();
        config.increment();

        assertEquals(2, config.getCounter());

        Configure configInstace = config.getInstance();


        //　GetInstanceで取得し直しても同一インスタンスを参照している
        assertEquals(2, configInstace.getCounter());
    }

    @Test
    public void SameInstanceTest(){
        // 上記のClassを抜けても、インスタンス情報を保持している。
        // ガベージコレクションに回収されないのでは？
        Configure otherConfigure = Configure.getInstance();
        assertEquals(2, otherConfigure.getCounter());
        
    }
}
