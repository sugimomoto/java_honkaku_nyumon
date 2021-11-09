package chapter_12_2_2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BuilderPattern {
    
    @Test
    public void PageBuilderTest(){

        // Builder を実装したClassを増やせば、使い回すことができる。
        Builder builder = new TopPageBuilder();

        // DirectorはBuilderインターフェースのメソッドを活用して、Product・インスタンスを生成する。
        Director director = new Director(builder);

        Page page = director.construct();

        assertEquals("Top Page Header", page.getHeader());

    }
}
