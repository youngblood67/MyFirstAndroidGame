package org.cnam.mannelejump;

import android.graphics.Bitmap;

public abstract class GameObject extends MainGameObject {

    protected static int canvasHeight = 0;
    protected double xSpeed, ySpeed;
    protected double mass;
    protected int gravity;


    GameObject(GameSceneView gameSceneView) {
        super(gameSceneView);
    }


    public abstract void update(double dt);

    //GETTERS and SETTERS


    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public double getySpeed() {
        return ySpeed;
    }

    public void setySpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }
}
