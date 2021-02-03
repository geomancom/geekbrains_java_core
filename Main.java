package lesson_2;
import java.util.Random;

public class Main {
    // Настройки
    public static final int SIZE_HIGHT = 4;
    public static final int SIZE_WIDTH = 4;
    public static final boolean ERROR_TEXT = true; // Специально для вызова ошибки

    // Начало
    public static final String[][] myArray = new String[SIZE_HIGHT][SIZE_WIDTH];
    public static final Random random = new Random();
    public static final int RANGE = 40;

    public static void main(String[] args) {
        try {
            if (myArray.length == 4 && myArray[0].length == 4) {
                String[][] correctArray = fillMyArray(myArray);
                showMyArray(correctArray);
                int sum = sumMyArray(correctArray);
                if (ERROR_TEXT) {
                    System.out.println("Сумма элементов массива до возникновения ошибки равна: "+sum);
                }
                else {
                    System.out.println("Сумма всех элементов массива равна: "+sum);
                }
            }
            else {
                throw new MyArraySizeException();
            }
        } catch (MyArraySizeException e) {
            System.out.println("Входящий массив myArray не является массивом 4х4");
        }

    }

    public static String[][] fillMyArray(String[][] rightArray){
        for (int i = 0; i < SIZE_HIGHT; i++) {
            for (int j = 0; j < SIZE_WIDTH; j++) {
                rightArray[i][j] = String.valueOf(random.nextInt(RANGE));
            }
        }
        // Специально для вызова ошибки
        if (ERROR_TEXT) {
            rightArray[3][3] = "text";
        }
        return rightArray;
    }

    private static void showMyArray(String[][] correctArray) {
        System.out.println("Был сгенирированн следующий массив:");
        for (int i = 0; i < SIZE_HIGHT; i++) {
            for (int j = 0; j < SIZE_WIDTH; j++) {
                System.out.print(correctArray[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int sumMyArray(String[][] correctArray){
        int result = 0;
        String message = "";
        try {
            for (int i = 0; i < SIZE_HIGHT; i++) {
                for (int j = 0; j < SIZE_WIDTH; j++) {
                    message ="rightArray["+i+"]["+j+"]";
                    result += Integer.parseInt(correctArray[i][j]);                     
                }
            }
        }catch (NumberFormatException e) {
            throw new MyArrayDataException("Входящий массив myArray содержит не только числа проблема выявлена в массиве "+message+" пожалуйста в настройках ERROR_TEXT укажите false");
        } finally {
            return result;
        }
    }


}
