package chapter_12_2_3;

public class Configure {
    
    private static Configure instance = new Configure();

    private String propertySample;

    private int counter;

    // private コンストラクタなので、新しくインスタンスを読み込めない
    private Configure(){
        // 
        this.counter = 0;
        this.propertySample = "HelloSingleton";
    }

    public static Configure getInstance(){
        return instance;
    }

    public String getPropertySample(){
        return this.propertySample;
    }

    public void increment(){
        this.counter++;
    }

    public int getCounter(){
        return this.counter;
    }
}
