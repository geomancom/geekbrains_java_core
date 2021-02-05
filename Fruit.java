package lesson_3;

public class Fruit {
    float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public void addFruit(float weight) {
        this.weight += weight;
    }

    public void minusFruit(float weight) {
        this.weight -= weight;
    }

    public float getWeight() {
        return weight;
    }
}

