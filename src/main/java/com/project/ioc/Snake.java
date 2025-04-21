package com.project.ioc;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Snake {
    private Cell head;
    //arrayList
    //private ArrayList<Cell> snakeBody = new ArrayList<>();
    private LinkedList<Cell> snakeBody = new LinkedList<>();
    private Set<Cell> bodySet = new HashSet<>();

    public Snake(Cell headCell) {
        if(headCell == null) throw new IllegalArgumentException("Head cell cannot be null");
        //this.head = headCell;
        addHead(headCell);
    }


    private void addHead(Cell headCell) {
        snakeBody.addFirst(headCell);
        bodySet.add(headCell);
        headCell.setType(CellType.SNAKE);
        head = headCell;
    }


    private void removeTail(){
        Cell tail = snakeBody.removeLast();
        System.out.println("tail : "+ tail);
        bodySet.remove(tail);
        System.out.println("Was removed? " + !bodySet.contains(tail)); // should be false
        tail.setType(CellType.EMPTY);
    }

    //O(1) double linked list
    //when the snake eat, a cell is added to the end
    public void eat(Cell nextCell){
        addHead(nextCell);
    }

    // research is O(1)
    public boolean checkCrash(Cell nextCell){
        System.out.println("Checking for crash");
        return bodySet.contains(nextCell);
    }


    // [HEAD S S S S ]
    public void move(Cell nextCell){
        addHead(nextCell);
        removeTail();
    }

    public LinkedList<Cell> getSnakeBody() {
        return snakeBody;
    }

    public void setSnakeBody(LinkedList<Cell> snakeBody) {
        this.snakeBody = snakeBody;
        this.bodySet = new HashSet<>(snakeBody);
    }

    public Set<Cell> getBodySet() {
        return this.bodySet;
    }
    public Cell getHead() {
        return head;
    }

    public void setHead(Cell head) {
        this.head = head;
    }
}
