package chapter_3_4_1;

public enum DayOfTheWeek {
    Sunday(1,"日曜日"),
    Monday(2,"月曜日"),
    Tuesday(3,"火曜日"),
    Wednsday(4,"水曜日"),
    Thursday(5,"木曜日"),
    Friday(6,"金曜日"),
    Saturday(7,"土曜日");

    private int code;
    private String japaneseName;

    private DayOfTheWeek(int code,String japaneseName){
        this.code = code;
        this.japaneseName = japaneseName;
    }

    public int getCode(){
        return code;
    }

    public String getJapaneseName(){
        return japaneseName;
    }
}
