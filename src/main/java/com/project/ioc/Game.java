package com.project.ioc;

import java.util.Random;

public class Game {


    private boolean gameOver;
    private int score;

    private Direction currentDirection;


    private Snake snake;
    private Board board;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction newDirection) {
        if(newDirection == null) return;
        if(currentDirection!=null && isOpposite(this.currentDirection, newDirection)) {
            System.out.println("Forbidden move, the snake will keep the same direction");
        } else{
            this.currentDirection = newDirection;
        }
    }
    public boolean isOpposite(Direction d1, Direction d2) {
        return (d1==Direction.RIGHT && d2==Direction.LEFT ) ||
                (d1==Direction.UP && d2==Direction.DOWN )
                || (d1==Direction.DOWN && d2==Direction.UP )
                || (d1==Direction.LEFT && d2==Direction.RIGHT );
    }

    public void startGame(){
        this.board = new Board(5);
        gameOver = false;
        this.score = 0;

        //init the direction
        this.currentDirection= null;


        //to change this to be random
        Cell startCell = board.getCell(2,2);
        this.snake = new Snake(startCell);
        spawnFood();

    }

    public void spawnFood(){
        Random random = new Random();
        while(true){
            int col = random.nextInt(board.getSize());
            int row = random.nextInt(board.getSize());
            Cell cell = board.getCell(row, col);
            if(cell.getType()==CellType.EMPTY){
                cell.setType(CellType.FOOD);
                break;
            }

        }
    }

    Cell getNextCell(Direction direction){
        int rowCount = board.getSize();
        int colCount = board.getSize();

        Cell head = this.snake.getHead();
        int headRow = head.getRow();
        int headCol = head.getColumn();

        if(direction== null){
            System.out.println("The direction entered is null.");
            return null;
        }
        switch(direction){
            case UP -> headRow=(headRow-1+rowCount)%rowCount;
            case DOWN -> headRow=(headRow+1)%rowCount;
            case LEFT -> headCol=(headCol-1+colCount)%colCount;
            case RIGHT -> headCol=(headCol+1)%colCount;
        }
        return board.getCell(headRow, headCol);
    }

    public void updateGame(Direction direction){
        if(gameOver){
            return;
        }

        Cell nextCell = getNextCell(direction);

        System.out.println(nextCell);

        if( snake.checkCrash(nextCell)){
            setGameOver(true);
            System.out.println("Game over.");
            return;
        } else if(nextCell.getType()==CellType.FOOD){
            snake.eat(nextCell);
            score++;
            spawnFood();
        } else{
            snake.move(nextCell);
        }
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }


}
