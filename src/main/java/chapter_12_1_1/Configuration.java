package chapter_12_1_1;

public abstract class Configuration {

    private String configurationName;

    public String getConfigurationName(){
        return configurationName;
    }

    public abstract void setConfigurationName();

    public void setConfigurationName(String configurationName){
        this.configurationName = configurationName;
    };
}
