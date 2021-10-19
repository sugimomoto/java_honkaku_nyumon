package chapter_9_1_1;


import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateClassTest {
    
    @Test
    public void DateClassMethodTest(){
        Date now = new Date();
        System.out.println(now);

        // Long型のコンストラクターを使ってインスタンスを生成すると
        // 1970年1月1日午前0時（GMT）から5,000ミリ秒経過した時刻になる
        Date after5000 = new Date(5000);
        System.out.println(after5000);

    }

    @Test
    public void CalendarClassMethodTest(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

    }
}
