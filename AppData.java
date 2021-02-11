package lesson_5;

public class AppData {
    private static String[] header = {"Value 1","Value 2","Value 3"};
    private static int[][] data = {{100,200,123},{300,400,500}};


    public static String[] getHeader() {
        return header;
    }

    public static int[][] getData() {
        return data;
    }
}
