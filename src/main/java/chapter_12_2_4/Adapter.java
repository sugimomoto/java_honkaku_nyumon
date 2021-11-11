package chapter_12_2_4;

public class Adapter extends OldSystem implements Target {

    @Override
    public String process() {
        String oldStatusCode = super.oldProcess();

        return "New process called old process : " + oldStatusCode;
    }
}
