package org.cnam.mannelejump;

import android.graphics.Canvas;

public class Platform extends GameObject {

    private static final int GRAVITY = 1;

    Platform(GameSceneView gameSceneView, int drawable) {
        super(gameSceneView, drawable);
        this.x = 300;
        this.y = 200;
        this.ySpeed = GRAVITY;
    }

    @Override
    public void update(double dt) {

    }

    @Override
    public void onDraw(Canvas canvas) {
        gravity(canvas.getHeight());
        canvas.drawBitmap(this.bitmap, this.x - this.width / 2, this.y - this.height / 2, null);
    }

    @Override
    public void gravity(int maxHeight) {
        this.y += ySpeed;
        if (this.y >= maxHeight) this.y = 0;
    }


}
