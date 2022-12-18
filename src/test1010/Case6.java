package test1010;
import java.sql.*;

public class Case6 extends test10 {
    public static void main() throws SQLException {
        String query = "SELECT * FROM " + tablename + "";
        PreparedStatement stmt1 = con.prepareStatement(query);
        ResultSet rs = stmt1.executeQuery();
        System.out.println("Сохраненные результаты: ");
        System.out.printf("%3s | %30s | %10s | %20s |\n", "ID", "NAME", "GROUP", "DIRECTION");
        while (rs.next()){
            int id_ = rs.getInt("id");
            String name_ = rs.getString("full_name");
            String group_ = rs.getString("group_name");
            String direction_ = rs.getString("direction");
            System.out.printf("%3d | %30s | %10s | %20s |\n", id_, name_, group_, direction_);
        }
        System.out.println();

        System.out.println("Введите название для таблицы Excel:");
        String filename = in.nextLine();
        String query2 = "SELECT 'id', 'NAME', 'GROUP', 'DIRECTION' UNION ALL SELECT * FROM " + tablename + " INTO OUTFILE '/Users/nasya/Desktop/postgresql/" + filename + ".xls' CHARACTER SET cp1251 ";
        PreparedStatement stmt2 = con.prepareStatement(query2);
        stmt2.executeQuery();
        System.out.println("Данные успешно сохранены в Excel.");
    }
}
