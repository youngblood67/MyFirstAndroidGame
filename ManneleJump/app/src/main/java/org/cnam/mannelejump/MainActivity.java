package org.cnam.mannelejump;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    GameSceneView gameSceneView;

    public static Movement santaMovement = Movement.STOP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameSceneView = new GameSceneView(this);
        gameSceneView.setOnTouchListener(this);
        setContentView(gameSceneView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameSceneView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameSceneView.resume();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (event.getX() <= (double) v.getWidth() / 2) {
                    santaMovement = Movement.LEFT;
                } else if (event.getX() > (double) v.getWidth() / 2) {
                    santaMovement = Movement.RIGHT;
                }
            case MotionEvent.ACTION_UP:

                break;
            case MotionEvent.ACTION_MOVE:

                break;
        }
        return true;
    }
}
