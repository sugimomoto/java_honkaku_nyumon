package chapter_12_1_1;

public class PostgreSQLConnection extends Connection {

    @Override
    public void setConnectionName(){
        super.setConnectionName("PostgreSQL");
    }
}
