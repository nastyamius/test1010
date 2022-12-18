package test1010;

import java.sql.*;

public class Case2 extends test10 {
    public static void main() throws SQLException {
        try {
            Statement stmt1 = con.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS " + tablename + " (id int, full_name varchar(1000), group_name varchar(1000), direction varchar(1000))";
            stmt1.executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Таблица " + tablename + " создана!");
    }
}
