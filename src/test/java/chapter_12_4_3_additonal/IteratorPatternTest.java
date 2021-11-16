package chapter_12_4_3_additonal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import chapter_12_4_3_additional.*;

public class IteratorPatternTest {
    
    @Test
    public void IteratorTest(){
        BookShelf bookShelf = new BookShelf(10);

        bookShelf.appendBook(new Book("Git hub"));
        bookShelf.appendBook(new Book("Qiita"));
        bookShelf.appendBook(new Book("Java"));
        bookShelf.appendBook(new Book("Iterator pattern"));

        Iterator iterator = bookShelf.iterator();

        int counter = 0;

        while (iterator.hasNext()) {
            Book book = (Book)iterator.next();
            counter++;
            if(counter == 2){
                assertEquals("Qiita", book.getName());
            }

        }

        assertEquals(4, counter);

    }
}
