package com.example.test;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label lblLabel;

    @FXML
    private TextField txtText;
    private int[][] board = new int[3][3];
    @FXML
    protected void handleClickMe() {
        setup();
        printBoard();

    }
    public void setup(){
        for (int i = 0; i<board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = 2;
            }
        }
    }
    public void printBoard(){
        for (int i = 0; i<board.length; i++) {
            System.out.print(" |");
            for (int j = 0; j < board.length-1; j++) {
                System.out.print( " , ");
            }
            System.out.print(" |");
            System.out.println();
        }
    }

}