import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PreparedStmt {
    public static void main(String[] args) throws Exception{
        String url ="jdbc:mysql://localhost:3306/dbname";
        String uname = "root";
        String pass = "";
        String query = "insert into employee values (?,?)";

        Class.forName("com.mysql.jdbc.Driver");
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection connection = DriverManager.getConnection(url,uname,pass);
        PreparedStatement ps = connection.prepareStatement(query);
        int count = ps.executeUpdate();
        System.out.println(count +" rows affected");
        ps.close();
        connection.close();
    }
}
