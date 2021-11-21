package chapter_12_4_4;

import java.util.ArrayList;
import java.util.List;

/**
 * 状態変更を監視するクラス
 */
public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();
    
    public void addObserver(Observer observer){
        this.observers.add(observer);
    }

    public void notifyObservers(){
        for(Observer observer : observers){
            observer.update(this);
        }
    }

    public abstract void execute();
}
