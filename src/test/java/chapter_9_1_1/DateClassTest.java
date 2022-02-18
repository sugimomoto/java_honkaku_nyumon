package chapter_9_1_1;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.Test;

import jakarta.mail.internet.ParseException;

public class DateClassTest {

    /*
    LocalDate, LocalTime, LocalDateTime はタイムゾーンの情報が無い、日付や時間のためのClass
    */

    @Test
    public void LocalDateTimeConfirm(){
        // このマシンのタイムゾーンをもとに、日付と時間を取得する。ただし、データとしてタイムゾーンは持たない。
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDateTime.toString());

        // タイムゾーンも含めて情報を取得している。
        Calendar calendar = Calendar.getInstance();

        System.out.println(calendar.toString());
        calendar.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
        System.out.println(calendar.get(Calendar.HOUR));

    }
    
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

    @Test
    public void DateFormartTest(){

        Calendar date = Calendar.getInstance();
        date.set(2021,10,24,11,22,00);
        DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");

        assertEquals("2021年11月24日11時22分", dateFormat.format(date.getTime()));
        
        try{
            Date resultDate = dateFormat.parse("2021年11月12日12時33分");
            assertTrue("message", resultDate.before(date.getTime()));

        } catch (java.text.ParseException e) {
            System.out.println(e);
        }
    }

    @Test
    public void LocalDateTimeFormatTest(){
        LocalDateTime date = LocalDateTime.of(2021, 10, 25, 07, 05, 10);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        assertEquals("2021/10/25 07:05:10", formatter.format(date));

        TemporalAccessor parsed = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").parse("2021/10/25 11:22:33");
        LocalDateTime datetime = LocalDateTime.from(parsed);
        assertEquals(2021,datetime.getYear());

        // 
        parsed = DateTimeFormatter.ISO_LOCAL_DATE.parse("2021-10-25");
        LocalDate dateFromISO = LocalDate.from(parsed);

        assertEquals(2021, dateFromISO.getYear());
    }

    @Test
    public void JapaneseDateTest(){

        // すげー。令和対応しているJapaneseDate Classがある。
        JapaneseDate japaneseDate = JapaneseDate.of(2021, 10, 25);

        System.out.println(japaneseDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("GGGGy年M月d日");
        
        assertEquals("令和3年10月25日", formatter.format(japaneseDate));
    }


}
