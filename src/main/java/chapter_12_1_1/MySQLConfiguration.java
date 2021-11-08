package chapter_12_1_1;

import org.eclipse.persistence.annotations.ValuePartition;

public class MySQLConfiguration extends Configuration {

    @Override
    public void setConfigurationName(){
        super.setConfigurationName("MySQL");
    }
}
