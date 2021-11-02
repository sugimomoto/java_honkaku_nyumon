package chapter_11_2_1;

public class IntIncrementer implements Runnable {

    private String name;
    private IntHolder holder;

    public IntIncrementer(String argName, IntHolder argHolder){
        this.name = argName;
        this.holder = argHolder;
    }

    @Override
    public void run() {
        System.out.printf("[%s] started.%n",name);

        for (int counter = 0; counter < 1000000; counter++) {
            holder.increment();
        }

        System.out.printf("[%s] finished.%n",name);
    }
}
