package chapter_12_1_1;

public abstract class Connection {
    private String connectionName;

    public String getConnectionName(){
        return this.connectionName;
    }

    public abstract void setConnectionName();

    public void setConnectionName(String connectionName){
        this.connectionName = connectionName;
    }

}
