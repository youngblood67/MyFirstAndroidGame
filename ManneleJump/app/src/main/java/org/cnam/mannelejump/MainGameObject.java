package org.cnam.mannelejump;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public abstract class MainGameObject {
    protected double x, y;
    protected double width, height;
    protected GameSceneView gameSceneView;

    MainGameObject(GameSceneView gameSceneView) {
        this.gameSceneView = gameSceneView;
    }

    public void initPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract void onDraw(Canvas canvas);


}
