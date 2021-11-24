package chapter_13_5_1;

public class Greeting {
    public String getMessage(int hour){
        String message;

        if(hour >= 17 || hour < 5){
            message = "こんばんは";
        }else if(hour < 11){
            message = "おはようございます";
        }else{
            message = "こんにちは";
        }

        return message;
    }
}
