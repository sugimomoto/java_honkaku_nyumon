package chapter_12_3_2;

public interface Entry {
    
    void add(Entry entry);

    void remove();

    void rename(String name);

    String getName();

}
