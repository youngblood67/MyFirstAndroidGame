package org.cnam.mannelejump;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    GameSceneView gameSceneView;

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
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                gameSceneView.santa.x = event.getX();
                gameSceneView.santa.y = event.getY();
                Log.i("INFO", String.valueOf(event.getX()) + " " + String.valueOf(gameSceneView.santa.x));
                Log.i("INFO", String.valueOf(event.getY()) + " " + String.valueOf(gameSceneView.santa.y));
            case MotionEvent.ACTION_UP:
                gameSceneView.santa.x = event.getX();
                gameSceneView.santa.y = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                gameSceneView.santa.x = event.getX();
                gameSceneView.santa.y = event.getY();
                break;
        }
        return true;
    }
}
