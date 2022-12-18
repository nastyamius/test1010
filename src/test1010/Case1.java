package test1010;

import java.sql.*;

public class Case1 extends test10 {
    public static void main() throws SQLException {
        Statement stmt1 = con.createStatement();
        ResultSet rs1 = stmt1.executeQuery("Show tables");
        System.out.println("Таблицы из текущей базы данных: ");
        while (rs1.next()) {
            System.out.print(rs1.getString(1));
            System.out.println();
        }
    }
}
