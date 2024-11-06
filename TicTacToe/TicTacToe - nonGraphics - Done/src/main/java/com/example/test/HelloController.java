package com.example.test;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Scanner;

public class HelloController {
    @FXML
    private Label lblLabel;

    @FXML
    private TextField txtText;
    private int[][] board = new int[3][3];
    private ArrayList<String> names = new ArrayList<>();
    private Scanner myObj = new Scanner(System.in);
    private int turn = 0;
    @FXML
    protected void handleClickMe() {
         // Create a Scanner object
        System.out.println("Enter name1");
        String userName = myObj.nextLine();  // Read user input
        names.add(userName);
        System.out.println("Enter name2");
        userName = myObj.nextLine();  // Read user input
        names.add(userName);

        setup();
        printBoard();
        turn = (int)(Math.random()*2);
        turn--;
        //get players
        //whos first
        while(!checkDone()){
            turn++;
            System.out.println(names.get(turn%2) + ", it is your turn");
            int move = myObj.nextInt();
            updateBoardWithUserInput(move);
            printBoard();


        }
    }

    private void updateBoardWithUserInput(int move) {
        //hello there
        switch (move) {
            case 1:  board[0][0] = turn%2;
                break;
            case 2:  board[0][1] = turn%2;
                break;
            case 3:  board[0][2] = turn%2;
                break;
            case 4:  board[1][0] = turn%2;
                break;
            case 5:  board[1][1] = turn%2;
                break;
            case 6:  board[1][2] = turn%2;
                break;
            case 7:  board[2][0] = turn%2;
                break;
            case 8:  board[2][1] = turn%2;
                break;
            case 9:  board[2][2] = turn%2;
                break;
        }

    }

    public boolean checkDone(){
        if (board[0][0]==board[1][1] && board[0][0]==board[2][2]&& board[0][0]!=2){
            System.out.println(names.get(turn%2) + " you have won");
            return true;
        }else if(board[0][2]==board[1][1] && board[0][2]==board[2][0]&& board[0][2]!=2){
            System.out.println(names.get(turn%2) + " you have won");
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            if(board[i][0]==board[i][1] && board[i][0]==board[i][2]&& board[i][0]!=2){
                System.out.println(names.get(turn%2) + " you have won");
                return true;
            }
        }

        for (int i = 0; i < board.length; i++) {
            if(board[0][i]==board[1][i] && board[0][i]==board[2][i]&& board[0][i]!=2){
                System.out.println(names.get(turn%2) + " you have won");
                return true;
            }
        }
        boolean check2 = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j]==2)
                    check2 = true;
            }
        }
        if(!check2){
            return true;
        }
        //check ties, wins, losses
        return false;
    }
    private void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }


    public void setup(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j]=2;
            }
        }
    }

}