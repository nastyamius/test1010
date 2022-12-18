package test1010;

public class Student{
    public static String[][] Students = new String[Case3.num][4];

    void add(String id, String name, String group, String direction){
        Students[Integer.parseInt(id)][0] = id;
        Students[Integer.parseInt(id)][1] = name;
        Students[Integer.parseInt(id)][2] = group;
        Students[Integer.parseInt(id)][3] = direction;
    }
}

final class Student1 extends Student {
    public static String[][] Students;

    @Override
    void add(String id, String name, String group, String direction){
        Students[Integer.parseInt(id)][0] = id;
        Students[Integer.parseInt(id)][1] = direction;
        Students[Integer.parseInt(id)][2] = name;
        Students[Integer.parseInt(id)][3] = group;
    }
}

final class Student2 extends Student {
    public static String[][] Students;

    @Override
    void add(String id, String name, String group, String direction){
        Students[Integer.parseInt(id)][0] = id;
        Students[Integer.parseInt(id)][1] = group;
        Students[Integer.parseInt(id)][2] = name;
        Students[Integer.parseInt(id)][3] = direction;
    }
}
