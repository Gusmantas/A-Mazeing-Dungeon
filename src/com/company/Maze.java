package com.company;


import java.util.ArrayList;

public class Maze {
    private String[][] map = {
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}
    };
    private String[][] maze = {
            {"#", " ", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", " ", "#", "#", "#", "#", "#", " ", " ", " ", "#", "#", " ", " ", "#"},
            {"#", " ", "#", "#", " ", " ", " ", " ", "#", " ", "#", "#", "#", " ", "#"},
            {"#", " ", " ", " ", " ", "#", "#", "#", "#", " ", " ", "#", "#", " ", "#"},
            {"#", "#", " ", "#", " ", "#", "#", "#", "#", " ", " ", "#", "#", " ", "#"},
            {"#", "#", " ", "#", " ", "#", "#", "#", "#", "#", " ", " ", " ", " ", "#"},
            {"#", "#", " ", "#", " ", "#", "#", "#", "#", " ", " ", "#", "#", " ", "#"},
            {"#", "#", " ", " ", " ", "#", "#", "#", "#", " ", " ", "#", "#", " ", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", " ", "#", "#", " ", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", " ", " ", " ", " ", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", " ", "#", "#", " ", "#"},
            {"#", "#", "#", "#", " ", " ", " ", " ", " ", " ", "#", "#", "#", " ", "#"},
            {"#", "H", " ", " ", " ", "#", "#", "#", "#", " ", " ", " ", " ", " ", "#"},
            {"#", "#", "#", "#", "#", "#", "#", " ", " ", " ", "#", "#", "#", " ", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"}
    };
    private ArrayList<Room> rooms = new ArrayList<>();

    private final String WALL = "#";
    private final String HERO = "H";
    private final String ROOM = " ";

    public Maze(Hero hero){
        addHeroOnMapAndMaze(hero);
        addHeroSurroundingToMap(hero);
        createRoom();
    }

    public String[][] getMaze() {
        return maze;
    }

    public void print(Hero hero){
        addHeroOnMapAndMaze(hero);
        addHeroSurroundingToMap(hero);
        printMap();
        printMaze();
        System.out.println(hero.getRow());
        System.out.println(hero.getCol());
    }

    public void displayCurrentRoom(Hero hero){
        for (Room room : this.rooms){
            if (room.getPosY() == hero.getRow() && room.getPosX() == hero.getCol()){
                room.displayRoom(hero);
            }
        }
    }

    private void createRoom(){
        for (int row = 0; row < this.maze.length; row++){
            for (int col = 0; col < this.maze[0].length; col++){
                if (isARoom(new int[]{row, col})){
                    this.rooms.add(new Room(row, col));
                }
            }
        }
    }

    public boolean isARoom(int[] position){
        int row = position[0];
        int col = position[1];
        return this.maze[row][col].equals(ROOM);
    }

    public void removeHero(Hero hero){
        this.map[hero.getRow()][hero.getCol()] = ROOM;
        this.maze[hero.getRow()][hero.getCol()] = ROOM;
    }
/*
    private void changeHeroPositionTo(Hero hero, int posY, int posX){
        hero.move(posY, posX);
    }
*/
    private void addHeroOnMapAndMaze(Hero hero){
        this.map[hero.getRow()][hero.getCol()] = HERO;
        this.maze[hero.getRow()][hero.getCol()] = HERO;
    }

    public void printMap(){
        for (String[] row : this.map){
            for (String elem : row){
                System.out.printf("[%s]", elem);
            }
            System.out.println();
        }
    }

    public void printMaze(){
        for (String[] row : this.maze){
            for (String elem : row){
                System.out.printf("[%s]", elem);
            }
            System.out.println();
        }
    }

    private void addHeroSurroundingToMap(Hero hero){
        int heroPosY = hero.getRow();
        int heroPosX = hero.getCol();

        // left of hero
        if (heroPosX > 0) {
            this.map[heroPosY][heroPosX - 1] = this.maze[heroPosY][heroPosX - 1];
        }
        // right
        if (heroPosX + 1 < this.map[0].length){
            this.map[heroPosY][heroPosX + 1] = this.maze[heroPosY][heroPosX + 1];
        }
        // top
        if (heroPosY > 0) {
            this.map[heroPosY - 1][heroPosX] = this.maze[heroPosY - 1][heroPosX];
        }
        // bottom
        if (heroPosY + 1 < this.map.length){
            this.map[heroPosY + 1][heroPosX] = this.maze[heroPosY + 1][heroPosX];
        }
    }

}
