package test1010;

import java.sql.PreparedStatement;
import java.sql.*;

public class Case4 extends test10 {
    public static void main() throws SQLException {
        System.out.print("Введите ID студента для вывода (целое число): ");
        String s = in.nextLine();
        int flag = 0;
        int id_sel = -5;
        while (flag==0) {
            try {
                id_sel = Integer.parseInt(s);
                flag = 1;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода. Введите целое число");
            }
        }
        String query = "SELECT * FROM " + tablename + " WHERE id=" + id_sel + "";
        PreparedStatement stmt1 = con.prepareStatement(query);
        ResultSet rs = stmt1.executeQuery();
        System.out.println("Вывод студента с id " + id_sel + " состояния таблицы: ");
        System.out.printf("%3s | %30s | %10s | %20s |\n", "ID", "NAME", "GROUP", "DIRECTION");
        while (rs.next()){
            int id_ = rs.getInt("id");
            String name_ = rs.getString("full_name");
            String group_ = rs.getString("group_name");
            String direction_ = rs.getString("direction");
            System.out.printf("%3d | %30s | %10s | %20s |\n", id_, name_, group_, direction_);
        }

    }
}
