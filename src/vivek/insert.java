import java.sql.PreparedStatement;
import java.sql.*;
public class insert{
    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "manager");
            String sql = "INSERT INTO student(regno, name, marks) VALUES(?,?,?)";
            String update = "UPDATE student SET marks=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 101);
            ps.setString(2, "Jyo");
            ps.setInt(3, 90);
            ps.addBatch();
            ps.setInt(1, 102);
            ps.setString(2, "Sai");
            ps.setInt(3, 80);
            ps.addBatch();
            int[] rows = ps.executeBatch();
            if (rows.length > 0) {
                System.out.println("Data inserted");}
            ps.close();
            con.close();} catch (Exception e) {
            e.printStackTrace();
        }
    }
}I