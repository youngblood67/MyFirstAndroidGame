package org.cnam.mannelejump;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class CommandPad extends MainGameObject {
    private int nbClic = 0;
    Bitmap bitmap;

    CommandPad(GameSceneView gameSceneView, int drawable) {
        super(gameSceneView);


    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.bitmap, (int)(canvas.getWidth() / 2 - (this.width / 2)), (int)(canvas.getHeight() - (this.height + 20)), null);
    }

    public void clicJumpButton() {
        this.nbClic++;
        if (this.nbClic % 2 == 1) {
            this.bitmap = BitmapFactory.decodeResource(gameSceneView.getResources(),R.drawable.jumpbtn2);
        } else {
            this.bitmap = BitmapFactory.decodeResource(gameSceneView.getResources(),R.drawable.jumpbtn1);
        }
    }

}
