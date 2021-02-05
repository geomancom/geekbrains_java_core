package lesson_3;

import java.util.Random;

public class Dz_3_2 {
    public static final Random random = new Random();
    static final int NUMBERS_TIP_FRUIT = 2;
    static final int NUMBERS_BOXES = 7;
    static final int NUMBERS_FRUIT_IN_BOX = 3;
    static final String tip1 = "Orange";
    static final String tip2 = "Apple";


    public static void main(String[] args) {
        Box<?>[] array_boxes = new Box[NUMBERS_BOXES];
        generation(array_boxes);
        comparison(array_boxes);
        exchange(array_boxes);


    }
    public static void generation(Box<?> array_boxes[]){

        for (int i = 0; i < NUMBERS_BOXES; i++) {
            int j = i+1;
            if (myRandom(NUMBERS_TIP_FRUIT, 0) == 0){
                Fruit type = new Orange(myRandom(NUMBERS_FRUIT_IN_BOX, 1));
                array_boxes[i] =  new Box<>(type);
                System.out.println("Добавили коробку № "+j+" с апельсинами весом: " + array_boxes[i].getWeight()+" кг.");
                array_boxes[i].addFruit(tip1);
            }else{
                array_boxes[i] =  new Box<>(new Apple(myRandom(NUMBERS_FRUIT_IN_BOX, 1)));
                System.out.println("Добавили коробку № "+j+" с яблоками весом: " + array_boxes[i].getWeight()+" кг.");
                array_boxes[i].addFruit(tip2);
            }
            System.out.println("      ID Коробки: "  + array_boxes[i].getBox()+ "\n      Тип фруктов в коробке: "+ array_boxes[i].whatInBox());


        }
        System.out.println("");

    }

    public static void comparison(Box<?> array_boxes[]){
        int number = myRandom(NUMBERS_BOXES, 0);
        int j = number+1;
        System.out.println("Сравниваем коробку № "+j+" - " + array_boxes[number].getBox());
        for (int i = 0; i < NUMBERS_BOXES; i++) {
            j = i+1;
            System.out.println(" с коробкой № "+j+" - "  + array_boxes[i].getBox() + "\n   Получаем: "+ array_boxes[number].compare(array_boxes[i]));
        }
    }

    public static void exchange(Box<?> array_boxes[]){
            System.out.println("Ищем коробку которую нужно наполнить ");
            int find_min = 100;
            int find_max = 0;
            int id_min = 0;
            int id_max = 0;
            for (int i = 0; i < NUMBERS_BOXES; i++) {
                if (array_boxes[i].getWeight() < find_min) {
                    find_min = (int) array_boxes[i].getWeight();
                    id_min = i;
                }
            }
            int j_min = id_min+1;
            System.out.println("Нашли легкую коробку № "+j_min+" - с весом "  + array_boxes[id_min].getWeight());
            System.out.println("     Это коробка с " + array_boxes[id_min].whatInBox());
            for (int i = 0; i < NUMBERS_BOXES; i++) {
                if (array_boxes[i].getWeight() > find_max && array_boxes[id_min].whatInBox() == array_boxes[i].whatInBox()) {
                    find_max = (int) array_boxes[i].getWeight();
                    id_max = i;
                }
            }
            array_boxes[id_min].whatInBox();
            int j_max = id_max+1;
            System.out.println("Нашли тяжелую коробку № "+j_max+" - с весом "+ array_boxes[id_max].getWeight());
            System.out.println("     Это коробка с " + array_boxes[id_max].whatInBox());
            array_boxes[id_max].replaceFruitsToMaxBox(array_boxes[id_min]);

            System.out.println("\nПроизводим объединение коробок");
            System.out.println("Лекая коробка № "+j_min+" - пуста: "  + array_boxes[id_min].getWeight());
            System.out.println("Тяжелую коробку № "+j_max+" - дополнили теперь она весит: "+ array_boxes[id_max].getWeight());
        }





    private static int myRandom(int amount, int coefficient){
        return random.nextInt(amount)+coefficient;
    }
}

