package chapter_12_4_3;

public interface Iterator<E> {
    boolean hasNext();

    E next();

    void remove();
}
