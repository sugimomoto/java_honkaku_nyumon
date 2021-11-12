package chapter_12_3_2;

public class File implements Entry {

    private String name;

    public File(String name){
        this.name = name;
    }


    @Override
    public void add(Entry entry) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove() {
        System.out.println(this.name + "を削除しました。");
    }

    @Override
    public void rename(String name) {
        this.name = name;
    }

    @Override
    public String getName(){
        return this.name;
    }


    @Override
    public String toString() {
        return "File [name=" + name + "]";
    }
}
