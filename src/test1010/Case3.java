package test1010;

import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class Case3 extends test10 {
    public static int num;
    public static void main() throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество студентов: ");
        num = in.nextInt();
        Student student = new Student();
        in.nextLine();
        for (int i=0; i<num; i++){
            System.out.print("Введите имя " + (i+1) + " студента: ");
            String name = in.nextLine();
            System.out.print("Введите группу " + (i+1) + " студента: ");
            String group = in.nextLine();
            System.out.print("Введите направление " + (i+1) + " студента: ");
            String direction = in.nextLine();
            student.add(Integer.toString(i), name, group, direction);
        }

        for (int i=0; i<num; i++){
            String query = "INSERT INTO " + tablename + " (id, full_name, group_name, direction) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, i);
            stmt.setString(2, student.Students[i][1]);
            stmt.setString(3, student.Students[i][2]);
            stmt.setString(4, student.Students[i][3]);
            stmt.executeUpdate();
        }
        System.out.println("\nДанные о студентах внесены в MySQL!\n");

        String query = "SELECT * FROM " + tablename + "";
        PreparedStatement stmt1 = con.prepareStatement(query);
        ResultSet rs = stmt1.executeQuery();
        System.out.println("Вывод текущего состояния таблицы: ");
        System.out.printf("%3s | %30s | %10s | %20s |\n", "ID", "NAME", "GROUP", "DIRECTION");
        while (rs.next()){
            int id_ = rs.getInt("id");
            String name_ = rs.getString("full_name");
            String group_ = rs.getString("group_name");
            String direction_ = rs.getString("direction");
            System.out.printf("%3d | %30s | %10s | %20s |\n", id_, name_, group_, direction_);
        }
        System.out.println();
    }
}
