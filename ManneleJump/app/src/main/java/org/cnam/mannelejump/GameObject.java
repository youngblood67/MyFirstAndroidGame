package org.cnam.mannelejump;

import android.graphics.Bitmap;

public abstract class GameObject extends MainGameObject {

    protected int xSpeed, ySpeed;


    GameObject(GameSceneView gameSceneView, int drawable) {
        super(gameSceneView, drawable);
    }


    public abstract void update(double dt);

    public abstract void gravity(int maxHeight);

    //GETTERS and SETTERS


    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }
}
