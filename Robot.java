package lesson_1;

public class Robot implements Run, Jump, Participant {
    public static final int ROBOT_RUN_MAX = 1000;
    public static final double ROBOT_JUMP_MAX = 1;

    protected final String name;
    public boolean inGame;
    public Robot(String name, boolean inGame) {
        this.name = name;
        this.inGame = inGame;
    }
    public void setInGame() {
        this.inGame = false;
    }

    @Override
    public void run(int meters) {
        if (this.inGame == true) {
            if (meters <= ROBOT_RUN_MAX) {
                System.out.println("Робот по имени " + name + " бежит " + meters + " м.");
            } else {
                System.out.println("Робот по имени " + name + " не может дальше бежать " + meters + " м. у него села батарейка");
                setInGame();
                System.out.println("Робот по имени " + name + " вышел из игры");
            }
        }
    }

    @Override
    public void jump(double height) {
        if (this.inGame == true) {
            if (height <= ROBOT_JUMP_MAX) {
                System.out.println("Робот по имени " + name + " прыгает на " + height + " м.");
            } else {
                System.out.println("Робот по имени " + name + " не может прыгнуть на " + height + " м. он повредился");
                setInGame();
                System.out.println("Робот по имени " + name + " вышел из игры");
            }
        }
    }

    @Override
    public void participant() {
        if (this.inGame == true) {
            System.out.println("Робот по имени " + name + " встречается с препятствием");
        }
    }
}
