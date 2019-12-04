package com.company;

import java.util.Scanner;

public class DragonQuest {
    Hero hero = null;
    DungeonGame game = null;

    public void quest() {
        System.out.println("Hello, traveler! Are you here for my treasure? You can either fight me for it, or do me a quest and I'll give it to you.");
        System.out.println("___________________");
        System.out.println("'1' To fight dragon");
        System.out.println("'2' To receive quest");
        System.out.println("'3' To give dragon his tooth");

        Scanner scanner = new Scanner(System.in);
        int userInput = Integer.parseInt(scanner.nextLine());

        switch (userInput) {
            case 1:
                System.out.println("Shall be it!");
                DragonBoss dragonBoss = new DragonBoss("Dino, the maze-keeper", 1000, 100, 1000);
                hero.heroFight(dragonBoss);
                if (dragonBoss.getHealth() <= 0) {
                    System.out.println("It's enough! I give up. You are a worthy opponent, therefore, i grant you my treasure! ");
                    completedGame();
                }
                break;

            case 2:
                System.out.println("I have lost my precious tooth somewhere in this maze, go find it, and I will reward you.");
                System.out.println("Hit <enter> to continue.");
                scanner.nextLine();
                break;

            case 3:
                System.out.println("I see you have found my tooth! Thank you, traveler. I'll give you my treasure for your troubles.");
                completedGame();
                break;
        }
    }

    private void completedGame(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("--CONGRATULATIONS ON COMPLETING A GAME!--");
        System.out.println("Hit <enter> to return to main menu.");
        scanner.nextLine();
        game.showMainMenu();
    }

}