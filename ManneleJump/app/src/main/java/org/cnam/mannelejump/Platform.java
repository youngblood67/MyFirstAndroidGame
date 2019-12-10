package org.cnam.mannelejump;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;

import java.util.ArrayList;

public class Platform extends GameObject {

    public Bitmap bitmap;


    Platform(GameSceneView gameSceneView, int drawable) {
        super(gameSceneView);
        bitmap = BitmapFactory.decodeResource(gameSceneView.getResources(), R.drawable.platform);
        this.width = this.bitmap.getWidth();
        this.height = this.bitmap.getHeight();
        this.ySpeed = 2;
    }

    @Override
    public void update(double dt) {
        if (this.y >= canvasHeight) this.y = 0;
        this.y = this.y + this.ySpeed;
        Log.i("INFO",String.valueOf(this.y));
    }

    @Override
    public void onDraw(Canvas canvas) {
    canvasHeight = canvas.getHeight();
    canvas.drawBitmap(this.bitmap, (int) (this.x - this.width / 2), (int) (this.y - this.height / 2), null);
    }

    public static ArrayList<Platform> generatePlatforms(GameSceneView g) {
        ArrayList<Platform> platforms = new ArrayList<>();

        Platform p1 = new Platform(g, R.drawable.platform);
        p1.initPosition(50, 100);
        platforms.add(p1);
        Platform p2 = new Platform(g, R.drawable.platform);
        p2.initPosition(350, 200);
        platforms.add(p2);
        Platform p3 = new Platform(g, R.drawable.platform);
        p3.initPosition(150, 300);
        platforms.add(p3);
        Platform p4 = new Platform(g, R.drawable.platform);
        p4.initPosition(650, 400);
        platforms.add(p4);
        Platform p5 = new Platform(g, R.drawable.platform);
        p5.initPosition(250, 500);
        platforms.add(p5);
        Platform p6 = new Platform(g, R.drawable.platform);
        p6.initPosition(850, 600);
        platforms.add(p6);
        Platform p7 = new Platform(g, R.drawable.platform);
        p7.initPosition(450, 700);
        platforms.add(p7);
        Platform p8 = new Platform(g, R.drawable.platform);
        p8.initPosition(20, 800);
        platforms.add(p8);
        Platform p9 = new Platform(g, R.drawable.platform);
        p9.initPosition(150, 900);
        platforms.add(p9);
        Platform p10 = new Platform(g, R.drawable.platform);
        p10.initPosition(550, 1000);
        platforms.add(p10);
        Platform p11 = new Platform(g, R.drawable.platform);
        p11.initPosition(450, 1100);
        platforms.add(p11);
        Platform p12 = new Platform(g, R.drawable.platform);
        p12.initPosition(50, 1180);
        platforms.add(p12);
        return platforms;
    }
}
