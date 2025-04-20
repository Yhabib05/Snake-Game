package com.project.ioc;

public class Board {
    private int size;
    private Cell[][] grid;

    public Board(int size) {
        this.size = size;
        grid = new Cell[size][size];
        for(int row=0; row<size; row++) {
            for(int col=0; col<size; col++) {
                grid[row][col]=new Cell(row,col,CellType.EMPTY);
            }
        }
    }

    public void printBoard(Snake snake, Direction direction ){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                Cell cell = getCell(i,j);
                if(cell == snake.getHead()){
                    if(direction==null){
                        System.out.print("S ");
                    } else{
                        System.out.print(switch(direction){
                            case Direction.UP -> "↑ ";
                            case Direction.DOWN -> "↓ ";
                            case Direction.LEFT -> "← ";
                            case Direction.RIGHT -> "→ ";
                        });
                    }
                }
                else{
                    System.out.print(getCell(i, j).getType() + " ");
                }
            }
            System.out.println(" ");
        }
    }

    public Cell getCell(int row, int col) {
        if (0<=row && row<size && 0<=col && col<size) {
            return grid[row][col];
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void setGrid(Cell[][] grid) {
        this.grid = grid;
    }
}
