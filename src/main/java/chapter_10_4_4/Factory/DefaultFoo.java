package chapter_10_4_4.Factory;

public class DefaultFoo implements Foo {

    private String message;

    DefaultFoo(String messasge){
        this.message = messasge;
    }

    @Override
    public String say() {
        return this.message;
    }

}
