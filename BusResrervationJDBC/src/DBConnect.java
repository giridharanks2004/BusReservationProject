import java.sql.*;
public class DBConnect {
    private static final String url = "jdbc:mysql://localhost:3306/BusReserve";
    private static final String username = "root";
    private static final String password = "root123";

    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(url, username, password);
    }
}
