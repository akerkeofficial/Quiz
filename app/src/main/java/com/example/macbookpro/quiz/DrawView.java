package com.example.macbookpro.quiz;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;



public class DrawView extends android.view.SurfaceView
        implements SurfaceHolder.Callback{

    boolean isRunning = false;
    SurfaceHolder surfaceHolder;

    Bitmap manImage;
    Chris man;
    int screenWidth = 0;
    int screenHeight = 0;
    float chrisX;
    float chrisY;

    public DrawView(Context context) {
        super(context);
        getHolder().addCallback(this);

        manImage = BitmapFactory.decodeResource(getResources(), R.drawable.you);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        surfaceHolder = holder;
        isRunning = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(isRunning){
                    Canvas canvas = surfaceHolder.lockCanvas();
                    if(canvas == null) continue;
                    long startTime = System.currentTimeMillis();
                    update();
                    draw(canvas);
                    long drawTime = System.currentTimeMillis() - startTime;
                    long fps = 1000/(drawTime==0?1:drawTime);
                    Log.d("fps", fps+"");
                    surfaceHolder.unlockCanvasAndPost(canvas);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isRunning = false;
    }

    public void update(){
        if(man!=null){
            man.move(screenWidth, screenHeight);
        }
    }

    public void draw(Canvas canvas){
        if(screenWidth==0) screenWidth = canvas.getWidth();
        if(screenHeight==0) screenHeight = canvas.getHeight();
        if(man==null) man = new Chris(screenWidth/6, manImage);

        canvas.drawColor(Color.WHITE);

        canvas.drawBitmap(man.image, man.getSrcRect(),
                man.getDestinationRect(), null);


//        Paint p = new Paint();
//        p.setColor(Color.BLACK);
//        p.setTextSize(150);
//        canvas.drawText(image.getWidth()+" "+image.getHeight(), 500, 1800, p);
    }
    public boolean onTouchEvent(MotionEvent event)
    {

        switch(event.getAction())
        {
//            case MotionEvent.ACTION_DOWN: {
//                if()
//                square.reverse();
//                Log.d("td","down");
//
//            }
//            break;

            case MotionEvent.ACTION_MOVE:
            {
                chrisX=(int)event.getX();
                chrisY=(int)event.getY();


                invalidate();

            }

            break;
//            case MotionEvent.ACTION_UP: {
//                square.reverse();
//            }


        }
        return true;
    }
}