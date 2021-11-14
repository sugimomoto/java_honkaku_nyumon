package chapter_12_4_2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import chapter_12_4_1.Book;

public class StrategyPatternTest {
    
    @Test
    public void StrategyTest(){
        Book comic = new Book(500);

        Book technicalBook = new Book(2500);

        Strategy discountStrategy = new DisountStrategy();
        Strategy specialDisountStrategy = new SpecialDiscountStrategy();

        // Shop が Strategy を扱う
        Shop shop = new Shop(discountStrategy);
        shop.sell(comic);

        assertEquals(450, comic.getAmout(),0);

        shop.setStrategy(specialDisountStrategy);
        shop.sell(technicalBook);

        assertEquals(1750, technicalBook.getAmout(),0);
    }
}
