package com.example.demo;



import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class HelloController
{
    FileInputStream oo;
    Image o,x,back;
    public HelloController(){
        FileInputStream oo,xx,backk;
        try {
            oo = new FileInputStream("src/main/Pictures/o.png");
            o = new Image(oo);
            xx= new FileInputStream("src/main/Pictures/x.png");
            x = new Image(xx);
            backk = new FileInputStream("src/main/Pictures/liteYellow.png");
            back = new Image(backk);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    GridPane gpane;
    @FXML
    private ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;
    @FXML
    private Label lbl1;

    private ImageView[][] board = new ImageView[3][3];
    //0 = o = p1, 1 = x = p2, 2 = not chosen
    int[][] boardData = new int[3][3];

    private int pturn = 0;
    @FXML
    private void handleStart(){
        gpane.setGridLinesVisible(true);
        board[0][0] = img1;
        board[0][1] = img2;
        board[0][2] = img3;
        board[1][0] = img4;
        board[1][1] = img5;
        board[1][2] = img6;
        board[2][0] = img7;
        board[2][1] = img8;
        board[2][2] = img9;
        gpane.setGridLinesVisible(true);
        for(int i = 0;i<board.length;i++)
            for(int j=0;j<board.length;j++){
                board[i][j].setImage(back);
                boardData[i][j] =2;
            }
    }
    private int row;
    private int column;
    @FXML
    private void handlePlay(MouseEvent t){
        row = GridPane.getRowIndex(((ImageView) t.getSource()));
        column = GridPane.getColumnIndex(((ImageView) t.getSource()));
        System.out.println(board[row][column].getImage());
        if(board[row][column].getImage() ==back){
            if(pturn%2==0){
                board[row][column].setImage(o);
                boardData[row][column] = 0;
            }else{
                board[row][column].setImage(x);
                boardData[row][column] = 1;
            }
            checkDone();
            pturn++;
        }

    }

    private void checkDone(){
        for (int i = 0; i < boardData.length; i++) {
            if(boardData[0][i]==boardData[1][i] && boardData[1][0]==boardData[2][i]&&boardData[0][i]!=2){
                System.out.println("player " + pturn%2 +" has won");
            }
        }
        for (int i = 0; i < boardData.length; i++) {
            if(boardData[i][0]==boardData[i][1] && boardData[i][1]==boardData[i][2]&&boardData[i][0]!=2){
                System.out.println("player " + pturn%2 +" has won");
            }
        }
        //still need to check diagonals and can combine the loops above but not necessary
    }

}
