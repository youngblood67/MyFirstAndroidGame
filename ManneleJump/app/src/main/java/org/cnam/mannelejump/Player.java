package org.cnam.mannelejump;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;

public class Player extends GameObject {

    private static final int GRAVITY = 6;
    private static final int JUMP_HEIGHT = 100;
    private static int canvasHeight = 0;
    private Bitmap[] bitmaps = new Bitmap[15];
    private boolean isJumping = false;
    private float startJumpAt = 0;

    Player(GameSceneView gameSceneView, int drawable) {
        super(gameSceneView, drawable);
        this.x = this.x - this.width / 2;
        this.y = this.y - this.height / 2;
        this.ySpeed = GRAVITY;
    }

    public void verifyIfLanding(Platform platform) {
        if ((this.x + (this.width) >= platform.x && this.x < platform.x + (this.width / 6)) && (this.y + this.height >= platform.y && this.y + this.height <= platform.y + (platform.height * 2))) {

            if (this.isJumping == false) {
                this.y = platform.y - (this.height);
                //this.ySpeed = platform.ySpeed;
                this.ySpeed = GRAVITY;
                this.isJumping = true;
                this.startJumpAt = this.y;
            }
        }

        if (!this.isJumping) {
            this.ySpeed = GRAVITY;
        } else {
            this.ySpeed = -GRAVITY;
        }

    }


    @Override
    public void update(double dt) {
        if (this.isJumping) {
            this.ySpeed = -GRAVITY;
            if (this.y <= this.startJumpAt - JUMP_HEIGHT) {
                this.isJumping = false;
            }
        }
        gravity(canvasHeight);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvasHeight = canvas.getHeight();
        canvas.drawBitmap(this.bitmap, this.x, this.y, null);
    }

    @Override
    public void gravity(int maxHeight) {
        this.y += this.ySpeed;
        if (this.y >= maxHeight) this.y = 0;
    }

    public Bitmap[] getBitmaps() {
        this.bitmaps[0] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump1);
        this.bitmaps[1] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump2);
        this.bitmaps[2] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump3);
        this.bitmaps[3] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump4);
        this.bitmaps[4] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump5);
        this.bitmaps[5] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump6);
        this.bitmaps[6] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump7);
        this.bitmaps[7] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump8);
        this.bitmaps[8] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump9);
        this.bitmaps[9] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump10);
        this.bitmaps[10] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump11);
        this.bitmaps[11] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump12);
        this.bitmaps[12] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump13);
        this.bitmaps[13] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump14);
        this.bitmaps[14] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump15);
        this.bitmaps[15] = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.jump16);
        return this.bitmaps;
    }

}
