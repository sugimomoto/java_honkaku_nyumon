package chapter_11_2_1;

public class LongPlusSetter implements Runnable {
    private String name;
    private LongHolder holder;

    public LongPlusSetter(String argName, LongHolder argHolder){
        this.name = argName;
        this.holder = argHolder;
    }

    public void run(){
        System.out.printf("[%s] stated.%n",name);
        for (int counter = 0; counter < 1000000; counter++) {
            holder.setPlus();
        }
    }
}
