package chapter_11_2_1;

public class IntHolder {
    private int intNum = 0;

    public int getResult(){
        return intNum;
    }

    public synchronized void increment(){
        intNum++;
        /* synchronized をつけると、アクセスできるスレッドが1つになる。
        synchronized(this){
            intNum++;
        }
        */
    }
}
