package org.cnam.mannelejump;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameSceneView extends SurfaceView implements Runnable {

    Thread thread = null;
    SurfaceHolder surfaceHolder;
    boolean running = false;
    Player santa;
    Platform platform;
    //CommandPad commandPad;
    int count = 0;
    double deltaTime;

    public GameSceneView(Context context) {
        super(context);
        surfaceHolder = getHolder();
        santa = new Player(this, R.drawable.jump4);
        platform = new Platform(this, R.drawable.platform);
        //commandPad = new CommandPad(this, R.drawable.jumpbtn1);
        //generatePlatforms en static
    }

    @Override
    public void run() {

        double lastTime = System.nanoTime();
        double time;
        while (running) {
            time = System.nanoTime();
            deltaTime = (time - lastTime) / 1000000000;
            lastTime = time;
            //Log.d("DEBUG", " deltaTime : " + String.valueOf(deltaTime));

            if (!surfaceHolder.getSurface().isValid()) {
                continue;
            }
            Canvas canvas = surfaceHolder.lockCanvas();

            clearCanvasInWhite(canvas);
            if (count == 0) {
                santa.initPosition(canvas.getWidth() / 2, canvas.getHeight() / 2);
            }
            ///draw here
            //commandPad.onDraw(canvas);
            santa.onDraw(canvas);
            santa.update(deltaTime);
            santa.verifyIfLanding(platform);

            platform.onDraw(canvas);

            surfaceHolder.unlockCanvasAndPost(canvas);
            count++;
        }
    }


    public static void clearCanvasInWhite(Canvas canvas) {
        Paint pWhite = new Paint();
        pWhite.setColor(Color.WHITE);
        canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), pWhite);
    }

    public void resume() {
        running = true;
        count = 0;
        thread = new Thread(this);
        thread.start();
    }

    public void pause() {
        running = false;
        while (true) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            break;
        }
    }

}
