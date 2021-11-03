package chapter_11_2_1;

public class LongHolder {
    
    private long longNum = 0;

    public long getResult(){
        return this.longNum;
    }

    public void setPlus(){
        longNum = 1;
        check(longNum);
    }

    public void setMinus(){
        longNum = -1;
        check(longNum);
    }

    private void check(long longNum) {
        if(longNum != 1 && longNum != -1){
            throw new RuntimeException("longNum: " + longNum);
        }
    }
}
