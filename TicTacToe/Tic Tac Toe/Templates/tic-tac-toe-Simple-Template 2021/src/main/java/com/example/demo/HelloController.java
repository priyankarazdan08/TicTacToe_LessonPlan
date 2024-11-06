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


    //0 = o = p1, 1 = x = p2, 2 = not chosen


    private int pturn = 0;
    @FXML
    private void handleStart(){
        gpane.setGridLinesVisible(true);
    }
    private int row;
    private int column;
    @FXML
    private void handlePlay(MouseEvent t){
        row = GridPane.getRowIndex(((ImageView) t.getSource()));
        column = GridPane.getColumnIndex(((ImageView) t.getSource()));
        System.out.println(row);







    }



}
