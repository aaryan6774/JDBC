//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import com.mysql.jdbc.Driver;

import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException{

        String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
        String username = "root";
        String password = "Neel@6774";
        String query = "INSERT INTO employees(id, name, job_title, salary)VALUES (4, 'Aaryan', 'Data Scietist', 150000.0 );";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded Succesfully");
        }catch (ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Establish Succeefully");
            Statement stmt = con.createStatement();
            int rowsaffected = stmt.executeUpdate(query);
            if(rowsaffected > 0)
            {
                System.out.println("Insert Successful" + rowsaffected + "rows affected.");
            }
            else
            {
                System.out.println("Insertion failed!!");
            }

            stmt.close();
            con.close();
            System.out.println("Connection Closed Succesfully");
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
