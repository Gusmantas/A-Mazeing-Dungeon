package com.company;

import java.io.Serializable;

public abstract class Creature implements Serializable {
    private String name;
    protected int health;
    protected int damage;
    protected int maxHealth;

    public Creature(String name, int health, int damage, int maxHealth) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.maxHealth = maxHealth;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public abstract int getDamage();

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int setHeroDamage(int damage) { // Setter for new damage?
        return this.damage = damage;
    }

    public int getHealth() { // getter for health
        return health;
    }

    public int setHeroHealth(int health) { //Setter for health ?
        return this.health = health;
    }

    public int setMonsterHealth(int health) {
        return this.health = health;
    }

    public void setHeroMaxHealth(int health) {
        this.maxHealth = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
    

    public void displayInfo() {
        System.out.printf(
                "Name: %s - Health: %d/%d - Damage: %s\n",
                this.name, this.health, this.maxHealth, this.damage
        );
    }

    @Override
    public String toString() {
        return this.name;
    }
}
