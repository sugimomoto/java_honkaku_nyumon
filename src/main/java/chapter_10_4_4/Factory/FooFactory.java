package chapter_10_4_4.Factory;

public class FooFactory {
    
    public static Foo newInstance(String message){
        return new DefaultFoo(message);
    }
}
