package chapter_12_1_1;

public class FactoryCreator {

    private String serviceName;
    
    public FactoryCreator(String serviceName){
        this.serviceName = serviceName;
    }

    public Factory createFactory(){
        switch (serviceName) {
            case "PostgreSQL":
                return new PostgreSQLFactory();
            case "MySQL":
                return new MySQLFactory();
            default:
                throw new IllegalArgumentException();
        }
    }
}
