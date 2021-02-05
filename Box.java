package lesson_3;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> implements AddFruit, WhatInBox {
    private ArrayList<T> box = new ArrayList<>();
    private String type;


    public Box(T... fruits) {
        this.box = new ArrayList<>(Arrays.asList(fruits));
    }

    public ArrayList<T> getBox() {
        return this.box;
    }

    public float getWeight() {
        float totalWeight = 0.0f;
        totalWeight += box.get(0).getWeight();
        return totalWeight;
    }


    public boolean compare(Box<? extends Fruit> boxСompared) {
        return Math.abs(getWeight() - boxСompared.getWeight()) < 0.0001f;
    }

    public void replaceFruitsToMaxBox(Box<?> minBox) {
        this.box.get(0).addFruit(minBox.getWeight());
        minBox.box.get(0).minusFruit(minBox.getWeight());
    }


    @Override
    public void addFruit(String fruit) {
        this.type = fruit;
    }

    @Override
    public String whatInBox() {
        return this.type;
    }
}

