package chapter_14_1_1;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Student {
    
    private int No;
    private String Name;
    private int Age;

    public int getNo() {
        return No;
    }
    public void setNo(int no) {
        this.No = no;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }

    public int getAge() {
        return Age;
    }
    public void setAge(int age) {
        this.Age = age;
    }
    
    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj){
        return EqualsBuilder.reflectionEquals(this, obj);
    }
    
}
