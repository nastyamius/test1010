package test1010;

import java.sql.*;
import java.util.Scanner;

public class test10 {
    protected static Scanner in = new Scanner(System.in);
    protected static String tablename;
    protected static String mysqlUrl = "jdbc:postgresql://localhost:5432/postgres";
    protected static Connection con;
    static{
        try{
            con = DriverManager.getConnection(mysqlUrl, "postgres", "12345");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException{
        int x = 0;
        String s = "";
        System.out.println("Введите название таблицы : ");
        tablename = in.nextLine();
        while (!"7".equals(s)){
            System.out.println("\n1.Вывести таблицы из базы данных. \n" +
                    "2. Создать таблицу в базе данных. \n" +
                    "3. Ввести данные о всех студентах и сохранить их в базу данных с последующим табличным выводом в консоль. \n" +
                    "4. Вывести данные о студенте по ID. \n" +
                    "5. Удалить данные о студенте по ID. \n" +
                    "6. Сохранить итоговые результаты в Excel и вывести их в консоль.\n" +
                    "7. Завершить сеанс. \n");
            s = in.nextLine();

            try {
                x = Integer.parseInt(s);
            }
            catch (NumberFormatException e){
                System.out.println(s);
                System.out.println("Неправильно введенные данные!");
            }

            switch (x){
                case 1 -> {
                    Case1.main();
                }
                case 2 -> {
                    Case2.main();
                }
                case 3 -> {
                    Case3.main();
                }
                case 4 -> {
                    Case4.main();
                }
                case 5 -> {
                    Case5.main();
                }
                case 6 -> {
                    Case6.main();
                }
                case 7 -> {
                    System.out.println("Вы завершили работу");
                }
            }
        }
    }
}