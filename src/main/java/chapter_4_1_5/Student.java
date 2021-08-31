package chapter_4_1_5;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public String getName(){
        return name;
    }

    // Comparable クラス の compareTo メソッドを実装することで、
    // 実装クラスの標準的なソートを指定することができる
    // ただし、汎用的なソートは実装できないので、その場合はComparatorを利用する。
    @Override
    public int compareTo(Student o){
        return Integer.compare(o.getScore(), getScore());
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.name,this.score);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        Student other = (Student)obj;
        if(score != other.getScore()){
            return false;
        }
        if(name != other.getName()){
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("Student [score=").append(score).append(",name=").append(name).append("]");
       return builder.toString();
    }

}
