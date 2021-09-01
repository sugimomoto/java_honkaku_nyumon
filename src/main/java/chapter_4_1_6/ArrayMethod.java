package chapter_4_1_6;

public class ArrayMethod {
    
    private String[] scores;

    private String message;

    // String... というメソッドの引数にすることで、new をしなくて良くなる。
    public ArrayMethod(String message, String... scores){

        this.message = message;
        this.scores = scores;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("ArrayMethod[message=").append(message).append("][scores=").append(String.join(",", scores)).append("]");
        return builder.toString();
    }


}
