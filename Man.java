package lesson_1;

public class Man implements Run, Jump, Participant {
    public static final int MAN_RUN_MAX = 200;
    public static final double MAN_JUMP_MAX = 1;

    protected final String name;
    public boolean inGame;
    public Man(String name, boolean inGame) {
        this.name = name;
        this.inGame = inGame;
    }
    public void setInGame() {
        this.inGame = false;
    }

    @Override
    public void run(int meters) {
        if (this.inGame == true) {
            if (meters <= MAN_RUN_MAX) {
                System.out.println("Человек по имени " + name + " бежит " + meters + " м.");
            } else {
                System.out.println("Человек по имени " + name + "не может бежать " + meters + " м. он устал");
                setInGame();
                System.out.println("Человек по имени " + name + " вышел из игры");
            }
        }
    }
    @Override
    public void jump(double height) {
        if (this.inGame == true) {
            if (height <= MAN_JUMP_MAX) {
                System.out.println("Человек по имени " + name + " прыгает на " + height + " м.");
            } else {
                System.out.println("Человек по имени " + name + " не кенгуру он не может прыгнуть на " + height + " м.");
                setInGame();
                System.out.println("Человек по имени " + name + " вышел из игры");
            }
        }
    }



    @Override
    public void participant() {
        if (this.inGame == true) {
            System.out.println("Человек по имени " + name + " встречается с препятствием ");
        }
    }
}
