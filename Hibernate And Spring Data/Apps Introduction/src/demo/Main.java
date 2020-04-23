package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        System.out.println("Enter username default (root): " );
        String user = reader.readLine().trim();
        user = user.equals("") ? "root" : user;

        System.out.println("Enter password default (empty): ");
        String password = reader.readLine();
        String myPassword = "Cveti271191";
        password = password.equals("") ? myPassword : password;

        Properties props = new Properties();




        props.setProperty("user", user);
        props.setProperty("password", password);

        //1. Load jdbc driver (optional)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        //2. Connect to DB
        System.out.println("Driver loaded successfully");


        //                                      userName : pass
        // DriverManager.getConnection("jdbc:mysql://root:root@localhost:3306/soft_uni?useSSL=false", props);
       Connection connection =
               DriverManager.getConnection("jdbc:mysql://localhost:3306/soft_uni?useSSL=false", props);
        System.out.println("Connected successfully");

        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM employees WHERE salary > ? ");
        System.out.println("Enter minimum salary: (default 20000)");
        String salaryStr = reader.readLine().trim();
        double salary = salaryStr.equals("") ? 20000 : Double.parseDouble(salaryStr);

        stmt.setDouble( 1, salary);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            System.out.println(String.format("| %-15.15s | %-15.15s | %10.2f |",
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getDouble("salary")
            ));
        }

        connection.close();
        
    }
}
