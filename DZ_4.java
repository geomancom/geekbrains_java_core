package lesson_4;

import java.util.HashMap;
import java.util.Map;

public class DZ_4 {
    public static void main(String[] args) {
        Dz_4_1();
        Dz_4_2();
    }

    private static void Dz_4_1() {
        Map<String, Integer> myHashMap = new HashMap<>();
        String[] myWords = {"абра", "кадабра", "мясо", "работа", "солнце", "высоко", "работа", "конь", "копыта", "волк", "лес", "мясо", "медведь", "мясо", "волк", "лес", "ночь", "луна", "солнце"};

        for (int i = 0; i < myWords.length; i++) {
            if (myHashMap.containsKey(myWords[i]))
                myHashMap.put(myWords[i], myHashMap.get(myWords[i]) + 1);
            else
                myHashMap.put(myWords[i], 1);
        }
        System.out.println(myHashMap);
    }

    private static void Dz_4_2() {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "345542");
        phoneBook.add("Петров", "234352");
        phoneBook.add("Сидоров", "345234");
        phoneBook.add("Петров", "214453");
        phoneBook.add("Козлов", "315623");
        phoneBook.add("Козлова", "235623");
        phoneBook.add("Иванова", "335134");
        phoneBook.add("Сидорова", "534235");
        phoneBook.add("Иванов", "123452");

        System.out.println("Иванов "+phoneBook.get("Иванов"));
        System.out.println("Петров "+phoneBook.get("Петров"));
        System.out.println("Козлов "+phoneBook.get("Козлов"));
    }
}


