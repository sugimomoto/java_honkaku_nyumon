package chapter_10_4_4.UseStatic;

public interface Foo {
    String say();

    static Foo newInstance(String message){
        return new DefaultFoo(message);
    }
}
