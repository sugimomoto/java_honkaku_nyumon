package chapter_12_2_2;

public interface Builder {
    void createHeader();

    void createContents();

    void createFooter();

    Page getResult();
}
