package chapter_12_4_1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CommandPatternTest {
    
    @Test
    public void CommandTest(){
        Book comic = new Book(500);

        Book technicalBook = new Book(2500);

        Command discountCommand = new DiscountCommand();

        Command specialDisountCommand = new SpecialDisountCommand();

        // Book 側で金額を処理するのではなく、Commandとして処理を定義する。
        // 割引処理をするクラスをインターフェースの抽象クラスCommand として用意することで、セットしたBookインスタンスの金額を調整する
        discountCommand.setBook(comic);
        discountCommand.execute();
        assertEquals(450, comic.getAmout(),0);

        specialDisountCommand.setBook(technicalBook);
        specialDisountCommand.execute();
        assertEquals(1750, technicalBook.getAmout(),0);

    }
}
