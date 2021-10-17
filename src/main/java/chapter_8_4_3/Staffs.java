package chapter_8_4_3;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.ToStringBuilder;


@XmlRootElement(name = "staffs")
public class Staffs {

    private List<Staff> staffList;

    @XmlElement(name = "staff")
    public List<Staff> getStaffList(){
        return staffList;
    }

    public void setStaffList(List<Staff> staffList){
        this.staffList = staffList;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
