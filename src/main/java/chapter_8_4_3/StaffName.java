package chapter_8_4_3;

import org.apache.commons.lang.builder.ToStringBuilder;

public class StaffName {
    private String firstname;

    private String lastname;

    public String getFirstname(){
        return firstname;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
