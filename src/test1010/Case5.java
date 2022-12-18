package test1010;

import java.sql.*;

public class Case5 extends test10 {
    public static void main() throws SQLException {
        System.out.print("Введите ID удаляемого студента (целое число): ");
        String s = in.nextLine();
        int flag = 0;
        int id_del = -5;
        while (flag == 0) {
            try {
                id_del = Integer.parseInt(s);
                flag = 1;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода. Введите целое число");
            }
        }
        Statement stmt1 = con.createStatement();
        String query = "DELETE FROM " + tablename + " WHERE id=" + id_del + "";
        stmt1.executeUpdate(query);
        System.out.println("Строка с id " + id_del + " успешно удалена!");
    }
}
