package lesson_1;

public class Obstacle {
    protected String tip;
    protected double measure;

    public Obstacle(String tip,  double measure) {
        this.tip = tip;
        this.measure = measure;
    }

    public void print_info(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "\n======================================================\nПрепятствие типа: " + tip + " метров = " + measure;
    }
}
