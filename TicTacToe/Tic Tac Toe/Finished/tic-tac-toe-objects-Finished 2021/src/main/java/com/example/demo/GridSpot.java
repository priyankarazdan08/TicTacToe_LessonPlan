package com.example.demo;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GridSpot {
    Image o,x,back;

    Image pick;
    //represents the turn of the player which is their spot
    int spot;
    String resourceLink = "";
    public GridSpot(){
        spot = 0;
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
    public void clickedSpot(int turn){
        //turn is passed in as a 1 or a 2
        spot = turn;
        if(spot == 1){
            //the picture would be an x for player 1
            pick = x;
        }else{
            //the picture would be an 0 for player 2
            pick = o;
        }
    }
    public int getSpot(){
        return spot;
    }
    public void setZero(){
        spot = 0;
    }
    public Image getResourceLink() {
        return pick;
    }
}
