package Model.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBgenerator {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/@localhost";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    public static Connection conectar() {
        try {
            return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al conectar a la base de datos.", e);
        }
    }
    public static void cerrarConexion(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
