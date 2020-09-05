package persistance;
import java.sql.*;

public class SQLConnection
{

    public static Connection getConnection ()
    {
        Connection connection = null;
        try {
            String  url = "jdbc:mysql://localhost:3306/car_booking";
            String  user = "root";
            String  password = "";

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver O.K.");

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion effective !");

            return connection;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return connection;
    }
}
