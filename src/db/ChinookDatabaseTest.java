package db;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

public class ChinookDatabaseTest {
	
    private ChinookDatabase database;

    @Before
    public void setUp() throws Exception {
        database = new ChinookDatabase();
    }

    @Test
    public void testOpeningConnection() throws ClassNotFoundException, SQLException {
        Connection connection = database.connect();
        assertNotNull(connection);

        connection.close();
    }

}
