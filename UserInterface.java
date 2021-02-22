package Dz_8;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
    private final Controller controller = new Controller();

    public void runApplication() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите город на английском :");
            String city = scanner.nextLine();

            setGlobalCity(city);

            System.out.println("Введите ответ: 1 - погода на 12 часов." + "2 - погода на 5 дней." + "Exit - выти.");
            String result = scanner.nextLine();

            IsExit(result);

            try {
                validateUserInput(result);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
            try {
                notifyController(result);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void IsExit(String result) {
        if (result.toLowerCase().equals("выход") || result.toLowerCase().equals("exit")) {
            System.exit(0);
        }
    }

    private void setGlobalCity(String city) {
        AppGlobalState.getInstance().setSelectedCity(city);
    }

    private void validateUserInput(String userInput) throws IOException {
        if (userInput == null || userInput.length() != 1) {
            throw new IOException("Неверрный ввод,ожидается один символ!");
        }
        int answer = 0;
        try {
            answer = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IOException("Неверный ввод,введены буквы!");
        }
    }

    private void notifyController(String input) throws IOException {
        controller.onUserInput(input);
    }

}
