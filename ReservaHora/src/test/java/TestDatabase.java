import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestDatabase {
    private static Connection connection;

    @BeforeAll
    public static void setup() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbexamencicd", "root", "");
    }

    @Test
    public void testDatabaseConnection() {
        //assertNotNull(connection, "Conexion vacia");
    }
}