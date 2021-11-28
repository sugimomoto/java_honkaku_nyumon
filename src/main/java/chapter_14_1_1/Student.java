package chapter_14_1_1;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Student {

    public Student(){

    }

    public Student(Student student) throws IllegalAccessException, InvocationTargetException{
        BeanUtils.copyProperties(this, student);
    }
    
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
