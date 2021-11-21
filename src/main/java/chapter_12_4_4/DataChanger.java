package chapter_12_4_4;

/**
 * データの変更通知をObserversに通知するクラス
 * {@inheritDoc}
 * 
 * @author Kazuya Sugimoto
 * @version 1.0
 * @since 1.0
 */
public class DataChanger extends Subject {

    /** データのステータス用フィールド */
    private int status;

    /**
     * ステータスをインクリメントする
     * 
     * @param none
     * @return none
     */
    @Override
    public void execute() {
        status++;
        System.out.println("Status が" + status + "に変わりました");
        notifyObservers();
    }
    
}
