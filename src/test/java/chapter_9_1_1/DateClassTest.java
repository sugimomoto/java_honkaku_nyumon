package chapter_9_1_1;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
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

        assertTrue("success", now.after(after5000));
    }

    @Test
    public void CalendarClassMethodTest(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        calendar.set(2013,9,22,18,36,42);

        assertEquals(2013, calendar.get(Calendar.YEAR));
        assertEquals(9, calendar.get(Calendar.MONTH));

        calendar.add(Calendar.YEAR, 2);

        assertEquals(2015, calendar.get(Calendar.YEAR));

        calendar.add(Calendar.MONTH, -2);
        assertEquals(7, calendar.get(Calendar.MONTH));

        Date now = new Date();

        assertTrue("message", now.after(calendar.getTime()));

    }

    @Test
    public void DateAndTimeAPITest(){
        LocalDate localDate = LocalDate.now();

        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();

        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDateTime);

        LocalDate localDateOf = LocalDate.of(2021, 10, 22);
        assertEquals("2021-10-22", localDateOf.toString());

        LocalTime localTimeOf = LocalTime.of(11, 22, 33);

        assertEquals("11:22:33", localTimeOf.toString());

        LocalDate localDateParse = LocalDate.parse("2021-10-22");

        assertEquals("2021-10-22", localDateParse.toString());
        assertEquals(2021, localDateOf.getYear());
        assertEquals(Month.OCTOBER, localDateOf.getMonth());
        assertEquals(10, localDateOf.getMonth().getValue());
        assertEquals(22, localDateOf.getDayOfMonth());

        // イミュータブルな値なので、インスタンスの中身の値が変わることは無いので注意
        localDateOf = localDateOf.plusYears(3);
        localDateOf = localDateOf.minusMonths(2);
        localDateOf = localDateOf.plusDays(5);

        assertEquals("2024-08-27", localDateOf.toString());
    }
}
