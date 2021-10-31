package chapter_10_4_4.UseStatic;

public class DefaultFoo implements Foo {

    private String message;

    DefaultFoo(String message){
        this.message = message;
    }

    @Override
    public String say() {
        return this.message;
    }
    
}
