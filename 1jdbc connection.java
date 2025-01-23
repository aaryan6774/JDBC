//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import com.mysql.jdbc.Driver;

import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException{

        String url = "jdbc:mysql://127.0.0.1:3306/mydatabase";
        String username = "root";
        String password = "Neel@6774";
        String query = "Select * from employees";
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
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                int id =  rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");
                System.out.println();
                System.out.println("========================");
                System.out.println("ID: " +id);
                System.out.println("Name: " +name);
                System.out.println("Job Title: " +job_title);
                System.out.println("Salary: " +salary);
            }

            rs.close();
            stmt.close();
            con.close();
            System.out.println("Connection Closed Succesfully");
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
