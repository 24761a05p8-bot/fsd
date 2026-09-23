package vivek;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class data {

    public static void main(String[] args) {

        try {

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter roll number:");
            int rno = sc.nextInt();

            System.out.println("Enter the student name:");
            String name = sc.next();

            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Create connection
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "system",
                    "manager");

            // Create statement
            Statement stmt = con.createStatement();

            // SQL query
            String query = "SELECT * FROM student WHERE sid = "
                    + rno + " AND sname = '" + name + "'";

            // Execute query
            ResultSet rs = stmt.executeQuery(query);

            // Check student
            if (rs.next()) {
                System.out.println(
                        "Successfully login by: " + rs.getString(2));
            } else {
                System.out.println("Not a student");
            }

            // Close
            rs.close();
            stmt.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

