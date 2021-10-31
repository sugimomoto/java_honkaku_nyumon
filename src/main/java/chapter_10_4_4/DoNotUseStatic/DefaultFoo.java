package chapter_10_4_4.DoNotUseStatic;

public class DefaultFoo implements Foo {

    private String message;

    public DefaultFoo(String message){
        this.message = message;
    }

    @Override
    public String say() {
        return this.message;
    }
}
