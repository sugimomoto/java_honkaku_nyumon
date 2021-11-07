package chapter_12_1_1;

public class MySQLFactory implements Factory {

    @Override
    public Connection getConnection() {
        // TODO Auto-generated method stub
        return new MySQLConnection();
    }

    @Override
    public Configuration getConfiguration() {
        // TODO Auto-generated method stub
        return new MySQLConfiguration();
    }
    
}
