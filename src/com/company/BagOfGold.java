package com.company;

public class BagOfGold extends Item {

    private int amountOfGold;

    public BagOfGold(String name, int amountOfGold, int value) {
        super(name, value);
        this.amountOfGold = amountOfGold;
    }

    public int getAmountOfGold() {
        return amountOfGold;
    }

    public void addAmountOfGold(int amount) {
        this.amountOfGold += amount;
    }

    public int removeGold(int amount) {
        return this.amountOfGold -= amount;
    }

    @Override
    public String toString() {
        return String.format("%d", amountOfGold);
    }
}