package com.project.ioc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting the game !");
        System.out.println("Use Z/S/Q/D to move. Press Enter to repeat last move.");

        Game game = new Game();



        game.startGame();

        Board board = game.getBoard();
        Snake snake = game.getSnake();


        Scanner scanner = new Scanner(System.in);
        //print the board before the game starts
        board.printBoard(snake,game.getCurrentDirection());

        while(!game.isGameOver()){
            String keyPress = scanner.nextLine();

            Direction newDirection = switch(keyPress.toUpperCase()){
                case "Z" -> Direction.UP;
                case "W" -> Direction.DOWN;
                case "Q" -> Direction.LEFT;
                case "D" -> Direction.RIGHT;
                default -> null;
            };
            if(newDirection != null){
                game.setCurrentDirection(newDirection);
            }

            //update the board
            game.updateGame(game.getCurrentDirection());
            //print the board
            board.printBoard(snake,game.getCurrentDirection());
        }
    }
}