package chapter_12_4_4;

public class DataChanger extends Subject {

    private int status;

    @Override
    public void execute() {
        status++;
        System.out.println("Status が" + status + "に変わりました");
        notifyObservers();
    }
    
}
