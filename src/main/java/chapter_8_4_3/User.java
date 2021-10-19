package chapter_8_4_3;

import javax.xml.bind.annotation.XmlRootElement;

import jakarta.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;


@XmlRootElement(name = "user")
public class User {

    private String name;

    private int age;

    @XmlElement(name = "name")
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    @XmlElement(name = "age")
    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }
    
}
