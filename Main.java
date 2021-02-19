package Dz6;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static int cycle = 1;
    public static int firstTime = 0;

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        while (true) {
            if (cycle >= 2) {
                cycle = 1;
                doQuestion();
                //System.out.println();
            }else{
                String user_request = begin();
                new GetLocationsKey(user_request);
                cycle++;
                firstTime = 1;
            }
        }
    }



    private static String begin() {
        if (firstTime > 0) {
            in.nextLine();
        }
        System.out.println("\nВведите название города: ");
        String request = in.nextLine();

        System.out.println("Ваш запрос " + request);
        return request;
    }


    private static void doQuestion() {
        System.out.println("\nЗакрыть программу или еще один запрос? 1 – запрос / 0 – закрыть");
        if (in.next().equals("0")){
            doExit();
        }else {
            System.out.println("Походу вы выбрали еще один запрос, если нет, то в следующий раз будьте внимательнее при выборе\n");
        }
    }

    private static void doExit() {
        System.out.println("Вы точно хотите выйти? y/n");
        String exit = in.next();
        if (exit.equals("y") || exit.equals("н") ) {
            System.exit(0);
        }
         else
             {
                System.out.println("Походу вы выбрали остаться, если нет, то в следующий раз будьте внимательнее при выборе\n");
             }
        }
}
