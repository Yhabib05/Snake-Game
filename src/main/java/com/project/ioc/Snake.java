package com.project.ioc;

import java.util.ArrayList;

public class Snake {
    private Cell head;
    private ArrayList<Cell> snakeBody = new ArrayList<>();

    public Snake(Cell headCell) {
        this.head = headCell;
        snakeBody.add(head);
        snakeBody.get(0).setType(CellType.SNAKE);
    }

    //when the snake eat, a cell is added to the end
    public void eat(Cell nextCell){
        snakeBody.add(0,nextCell);
        nextCell.setType(CellType.SNAKE);
        head = nextCell;
    }

    public boolean checkCrash(Cell nextCell){
        System.out.println("Checking for crash");
        for(Cell cell : snakeBody){
            if( cell == nextCell){
                return true;
            }
        }
        return false;
    }

    public void move(Cell nextCell){
        Cell tail = snakeBody.get(snakeBody.size()-1);
        tail.setType(CellType.EMPTY);

        snakeBody.remove(snakeBody.size()-1);

        snakeBody.add(0,nextCell);
        nextCell.setType(CellType.SNAKE);
        head = nextCell;
    }

    public ArrayList<Cell> getSnakeBody() {
        return snakeBody;
    }

    public void setSnakeBody(ArrayList<Cell> snakeBody) {
        this.snakeBody = snakeBody;
    }

    public Cell getHead() {
        return head;
    }

    public void setHead(Cell head) {
        this.head = head;
    }
}
