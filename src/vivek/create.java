import java.sql.*;
public class create {
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db",
                    "root",
                    "manager");
            Statement stmt = con.createStatement();
            String sql = "CREATE TABLE students(" + "regno INT PRIMARY KEY, " + "name VARCHAR(20), " + "marks INT)";

            stmt.executeUpdate(sql);
            System.out.println("Table Created");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}