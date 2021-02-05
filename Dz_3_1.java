package lesson_3;
import java.util.Random;

public class Dz_3_1 {
    public static final int SIZE = 10;
    public static final String[] myArray = new String[SIZE];
    public static final Random random = new Random();

    public static void main(String[] args) {
        String[] correctArray = fillMyArray(myArray);
        showMyArray(correctArray, 0);
        String[] newArray = exchangeMyArray(correctArray);
        showMyArray(newArray, 1);
    }



    public static String[] fillMyArray(String[] rightArray){
        for (int i = 0; i < SIZE; i++) {
            rightArray[i] = String.valueOf(myRandom());
        }
        return rightArray;
    }

    private static void showMyArray(String[] correctArray, int info) {
        if (info == 0) {
            System.out.println("Был сгенирированн следующий массив:");
        }
        if (info == 1) {
            System.out.println("Массив был обнавлен, текущий вариант:");
        }
        for (int i = 0; i < SIZE; i++) {
            System.out.print(correctArray[i]+" ");
        }
        System.out.println();
    }

    private static String[] exchangeMyArray(String[] rightArray){
        int a = myRandom();
        int b = myRandom();
        if (a == b){
            if (a == 0){
                b = b + 1;
            }
            if (b == SIZE-1){
                b = b - 1;
            }
        }
        System.out.println("Будет проведена замена следующих элементов ["+a+"] на ["+b+"] в массиве:");
        String buffer = rightArray[a];
        rightArray[a] = rightArray[b];
        rightArray[b] = buffer;
        return rightArray;
    }

    private static int myRandom(){
        return random.nextInt(SIZE-1);
    }

}
