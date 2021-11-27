package chapter_14_1_1;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class CommonLangTest {
    
    @Test
    public void CommonLangMethodTest(){


        String sample = null;

        // 通常はNullチェックとLengthチェックをしないと、Empty判定はできない
        assertEquals(true, (sample == null && sample.length() == 0));

        // CommonLang の StringUtilsであれば、isEmptyでチェックできる
        assertEquals(true, StringUtils.isEmpty(sample));
    }
}
