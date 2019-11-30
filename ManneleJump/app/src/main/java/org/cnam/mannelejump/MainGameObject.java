package org.cnam.mannelejump;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public abstract class MainGameObject {
    protected float x, y;
    protected int width, height;
    protected Bitmap bitmap;
    protected GameSceneView gameSceneView;

    MainGameObject(GameSceneView gameSceneView, int drawable) {
        this.gameSceneView = gameSceneView;
        this.bitmap = this.setBitmap(drawable);
        this.width = this.bitmap.getWidth();
        this.height = this.bitmap.getHeight();
    }

    public Bitmap setBitmap(int drawable) {
        this.bitmap = BitmapFactory.decodeResource(gameSceneView.getResources(), drawable);
        return this.bitmap;
    }

    public void initPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public abstract void onDraw(Canvas canvas);

    //GETTERS and SETTERS
    public void setX(float x) {
    }

    public void setY(float y) {
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public GameSceneView getGameSceneView() {
        return gameSceneView;
    }

    public void setGameSceneView(GameSceneView gameSceneView) {
        this.gameSceneView = gameSceneView;
    }
}
