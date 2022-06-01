import java.sql.*;

public class MyJDBC {

    public static void main(String[] args) throws Exception {
        String url ="jdbc:mysql://localhost:3306/dbname";
        String uname = "root";
        String pass = "";
        String querySingleSelect = "Select emplyeename from employee where employeeid=123";
        String selectAll = "Select * from employee"; // DQL fetch data from DB
        String insert = "Insert into employee values (4, 'Raj')"; // DML Modify values in DB

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, uname, pass);
        Statement st = connection.createStatement();
        //querySingleSelect
        ResultSet rs =  st.executeQuery(querySingleSelect);
        rs.next();
        String name = rs.getString("employeename"); // fetch value by columnname
        System.out.println("Employee Name is " +name);

        //selectAll
        ResultSet rsAll = st.executeQuery(selectAll);
        String output ="";
        while(rsAll.next()){
            output = rsAll.getString(1) +" : " + rsAll.getString(2); // fetch values by columnindex
            System.out.println(output);
        }

        //insert
        int count = st.executeUpdate(insert);
        System.out.println(count +" rows affected");
        st.close();
        connection.close();
    }
}
