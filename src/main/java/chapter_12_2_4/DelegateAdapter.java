package chapter_12_2_4;

public class DelegateAdapter extends AbstractTarget {

    private OldSystem oldSystem;

    public DelegateAdapter(){
        this.oldSystem = new OldSystem();

    }

    @Override
    String process() {
        String result = this.oldSystem.oldProcess();
        return result;
    }


    
}
