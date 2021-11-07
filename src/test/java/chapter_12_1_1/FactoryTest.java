package chapter_12_1_1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FactoryTest {
    
    @Test
    public void FactoryPatternPostgreSQLTest(){
        FactoryCreator creator = new FactoryCreator("PostgreSQL");

        Factory factory = creator.createFactory();

        Connection conn = factory.getConnection();
        conn.setConnectionName("PostgreSQL");

        assertEquals("PostgreSQL", conn.getConnectionName());

    }
}
