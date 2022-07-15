import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    private static Statement statement;
    private static Connection connection;

    private DatabaseConnection(){}

    public static Statement getInstance(String schema, String user, String password){
        if (statement == null) return createConnection(schema, user, password);
        return statement;
    }

    public static Connection getInstance(String schema, String user, String password, int getConnection){
        if (getConnection == 1) {
            if (connection == null) return getConnection(schema, user, password);
            return connection;
        }
        return null;
    }

    private static Connection getConnection(String schema, String user, String password) {
        String connectionURI = String.format("jdbc:mysql://localhost:3306/%s", schema);

        try {
            connection = DriverManager.getConnection(connectionURI, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    private static Statement createConnection(String schema, String user, String password) {

        String connectionURI = String.format("jdbc:mysql://localhost:3306/%s", schema);

        try {
            connection = DriverManager.getConnection(connectionURI, user, password);
            statement = connection.createStatement();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return statement;
    }
}