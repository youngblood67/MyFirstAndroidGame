package org.cnam.mannelejump;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

public class Player extends GameObject {

    //private Bitmap[] bitmaps = new Bitmap[15];

    Player(GameSceneView gameSceneView) {
        super(gameSceneView);
        this.width = 40;
        this.x = 400;
        this.y = 200;
        this.ySpeed = 20;
        this.gravity = 1;
    }

    public void verifyIfLanding(Platform platform) {
        if ((this.x + this.width*2.5  >= platform.x && this.x + this.width*1.5 < (platform.x+platform.width )) && ((this.y + this.width) >= platform.y && this.y + this.width <= platform.y + platform.height)) {
           ySpeed =  -20;
           gravity= 1;
        }

    }

    @Override
    public void update(double dt) {
        Log.i("INFO",MainActivity.santaMovement.toString());
        if(MainActivity.santaMovement == Movement.LEFT){
            this.x -= 5*(1+dt);
        }else  if(MainActivity.santaMovement == Movement.RIGHT){
            this.x += 5*(1+dt);
        }
        this.y = this.y + this.ySpeed;
        this.ySpeed = this.ySpeed + this.gravity ;

    }


    @Override
    public void onDraw(Canvas canvas) {
        canvasHeight = canvas.getHeight();
        canvas.drawCircle((float)this.x, (float)this.y, (float)this.width/2, getPaint());
        if(this.y > canvas.getHeight()){
            this.y = 0;
        }
        //canvas.drawBitmap(this.bitmap, (int) this.x, (int) this.y, null);
    }

    private Paint getPaint() {
        Paint p = new Paint();
        p.setColor(Color.rgb(250,20,20));
        p.setStrokeWidth(10);
        p.setStyle(Paint.Style.STROKE);
        return p;
    }


//    public Bitmap[] getBitmaps() {
//        this.bitmaps[0] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump1);
//        this.bitmaps[1] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump2);
//        this.bitmaps[2] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump3);
//        this.bitmaps[3] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump4);
//        this.bitmaps[4] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump5);
//        this.bitmaps[5] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump6);
//        this.bitmaps[6] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump7);
//        this.bitmaps[7] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump8);
//        this.bitmaps[8] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump9);
//        this.bitmaps[9] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump10);
//        this.bitmaps[10] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump11);
//        this.bitmaps[11] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump12);
//        this.bitmaps[12] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump13);
//        this.bitmaps[13] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump14);
//        this.bitmaps[14] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump15);
//        this.bitmaps[15] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump16);
//        return this.bitmaps;
//    }

}
