package chapter_12_4_2;

import chapter_12_4_1.Book;

public class Shop {
    private Strategy strategy;

    public Shop(Strategy strategy){
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public void sell(Book book){
        this.strategy.discount(book);
    }
}
