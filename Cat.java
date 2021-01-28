package lesson_1;

public class Cat implements Run, Jump, Participant {
    public static final int CAT_RUN_MAX = 500;
    public static final double CAT_JUMP_MAX = 2;

    protected final String name;
    public boolean inGame;

    public Cat(String name, boolean inGame) {
        this.name = name;
        this.inGame = inGame;
    }

    public void setInGame() {
        this.inGame = false;
    }

    @Override
    public void run(int meters) {
        if (meters <= CAT_RUN_MAX) {
            System.out.println("Кошка по имени " + name + " бежит " + meters + " м.");
        } else {
            System.out.println("Кошка по имени " + name + " не может бежать " + meters + " м. она пойдет по своим делам");
            setInGame();
            System.out.println("Кошка по имени " + name + " вышла из игры");
        }

    }
    @Override
    public void jump(double height) {
        if (height <= CAT_JUMP_MAX) {
            System.out.println("Кошка по имени " + name + " прыгает на " + height + " м.");
        }
        else {
            System.out.println("Кошка по имени " + name + " не резиновый мячь она не может прыгнуть на " + height + " м.");
            setInGame();
            System.out.println("Кошка по имени " + name + " вышла из игры");
        }
    }

    @Override
    public void participant() {
        System.out.println("Кошка по имени " + name + " встречается с препятствием");
    }


}
