package chapter_10_4_2;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Random;

public class CustomerDto extends Customer {
    private long no;

    public long getNo(){
        return this.no;
    }

    public void generateNo(){
        this.no = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
    }
}
