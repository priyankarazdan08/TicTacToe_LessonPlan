package com.example.demo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HelloController {

    public HelloController(){

    }

    @FXML
    Label lblTurn, lblResult, lblTaken;
    @FXML
    Button btnStart;
    @FXML
    GridPane gdpPlayGrid;
    //Creates a 2D array of the GridSpot Class that represent one spot on a Tic Tac Toe Board
    private GridSpot [][] board = new GridSpot[20][20];
    //Creates a 2D array of Buttons

    private Button [][] boardSpotsBTN = new Button[20][20];
    //turn = which player's turn
    int turn, rowIndex, colIndex;
    //tie is used to check if there is a tie or a win
    private boolean tie = false;
    @FXML
    private void start(){
        //after adding the grdipane in scenebuilder, modify the fxml manually to eliminate rows and columns
        //these are some sample properties to change how the gridpane looks
//        gdpPlayGrid.setHgap(10);
//        gdpPlayGrid.setVgap(10);
//        gdpPlayGrid.setPadding(new Insets(10));
        gdpPlayGrid.setGridLinesVisible(true);
//        gdpPlayGrid.setAlignment(Pos.CENTER);

//        turn is a random number: either 0 or 1 which represents the first or second player
        turn = (int) Math.round(Math.random()*1);
        lblTurn.setText("It is Player " + (turn%2) + "'s Turn!" );
        btnStart.setDisable(true);
        for (int i = 0; i < boardSpotsBTN.length; i++) {
            for (int j = 0; j < boardSpotsBTN.length; j++) {
                //initializes each of the indexes in the Button array
                boardSpotsBTN[i][j] = new Button();
                //sets each Buttons text
                boardSpotsBTN[i][j].setText("-");
                //sets size of buttons
                boardSpotsBTN[i][j].setMinHeight(35);
                boardSpotsBTN[i][j].setMinWidth(35);
                boardSpotsBTN[i][j].setPrefHeight(30);
                boardSpotsBTN[i][j].setPrefWidth(30);
                //similar to initializing a new class but for each spot in the array
                board[i][j] = new GridSpot();//calls constructor
                //Parameters:  object, columns, rows
                //adds each of the ImageViews to the GridPane in javafx at a specific spot
                //Paramters:  object, columns, rows
                gdpPlayGrid.add(boardSpotsBTN[i][j], j, i);

            }
        }

        //this is the mouse event: same as if you were adding it in scenebuilder but this lets you do it dynamically
        EventHandler z = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                //gets the row index of which button you clicked on
                rowIndex = GridPane.getRowIndex(((Button) t.getSource()));
                //gets the column index of which button you clicked on
                colIndex = GridPane.getColumnIndex(((Button) t.getSource()));
                System.out.println(rowIndex);
                System.out.println(colIndex);
                lblTaken.setText("-");
                display(rowIndex, colIndex, t);
                if(!checkDone()) {
                    System.out.println(turn % 2);
                    lblResult.setText("Result:");
                    switchTurn();
                }else{
                    reset();
                }

            }
        };

        for (int i = 0; i < boardSpotsBTN.length; i++) {
            for (int j = 0; j < boardSpotsBTN.length; j++) {
                //setting the onMouseClicked property for each of the buttons to call z (the event handler)
                boardSpotsBTN[i][j].setOnAction(z);
            }
        }
    }
    public boolean checkDone(){

        return false;

    }
    public void switchTurn(){
        //switches between player 1 and 2
        turn++;
        lblTurn.setText("It is Player " + (turn%2) + "'s Turn!" );

    }

    //row = row index; col = column index; t = the source at where the button was clicked
    public void display(int row, int col, ActionEvent t){
        //checking if there is already a value at the position where the user clicked
        if(board[row][col].getBtnText()!="-"){
            lblTaken.setText("Result: Pick a new spot");
            System.out.println("Taken");
            //turn is subtracted because the person gets another try
            turn--;
        }else{
            //changes board to the turn of the player (1 or 2)
            board[row][col].clickedSpot(turn%2);
            //gets the resource link of the image based on the turn and sets the image in ImageView 2D array and teh javafx GridPane
            boardSpotsBTN[row][col].setText(board[row][col].getBtnText());
//            ((ImageView) t.getSource()).setImage(new Image(board[k][j].getResourceLink()));

        }
        //using board which is initialized with 0's, sout board to make sure it all works
        for(int k = 0;k<board.length;k++){
            for(int j = 0; j<board.length;j++){
                System.out.print(board[k][j].getBtnText() + " ");
            }
            System.out.println("");
        }
    }
    public void reset(){
//
    }
}