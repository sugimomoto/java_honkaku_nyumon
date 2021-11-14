package chapter_12_4_2;

import chapter_12_4_1.Book;

public class DisountStrategy implements Strategy {

    @Override
    public void discount(Book book) {
        double amount = book.getAmout();
        book.setAmount(amount * 0.9);
        
    }
    
}
