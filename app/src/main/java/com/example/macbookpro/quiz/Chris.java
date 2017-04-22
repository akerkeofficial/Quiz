package com.example.macbookpro.quiz;

import android.graphics.Bitmap;
import android.graphics.Rect;

public class Chris {

    public int x = 200;
    public int y = 200;
    public int width;
    public int height;
    public int speed = 15;

    public Bitmap image;
    public int currentFrame = 0;
    public int frameWidth = 122;
    public int frameHeight = 130;
    public int movingFrameCount = 6;

    int direction = 1;
    int xSign = 1;
    int ySign = 1;

    public Chris(int width, Bitmap image){
        this.width = width;
        this.height = width*frameHeight/frameWidth;
        this.image = image;
    }

    public void move(int screenWidth, int screenHeight){
        x+=speed*direction;
        y+=speed*direction;

        currentFrame = (currentFrame+1)%movingFrameCount;

        if(x<0){
            direction = 1;
            x = 0;
            currentFrame = 0;
        }
        else if(x+width>screenWidth){
            x = screenWidth - width;
            direction = -1;
            currentFrame = 0;
        }
        if(y<0){
            direction = 1;
            y = 0;
            currentFrame = 0;
        }
        else if(y+height>screenHeight){
            y = screenHeight - height;
            direction = -1;
            currentFrame = 0;
        }
    }
    public Rect getSrcRect(){
        return new Rect(frameWidth*currentFrame, frameHeight*(direction==1?0:1),
                frameWidth*(currentFrame+1), frameHeight*(direction==1?1:2));
    }
    public Rect getDestinationRect(){
        return new Rect(x,y,x+width, y+height);
    }
    public void reverse(){
        xSign*=-1;
        ySign*=-1;
    }

}