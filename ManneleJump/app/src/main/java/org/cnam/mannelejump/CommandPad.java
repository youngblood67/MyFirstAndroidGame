package org.cnam.mannelejump;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class CommandPad extends MainGameObject {
    private int nbClic = 0;

    CommandPad(GameSceneView gameSceneView, int drawable) {
        super(gameSceneView, drawable);
        this.setBitmap(R.drawable.jumpbtn1);

    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.bitmap, canvas.getWidth() / 2 - (this.width / 2), canvas.getHeight() - (this.height + 20), null);
    }

    public void clicJumpButton() {
        this.nbClic++;
        if (this.nbClic % 2 == 1) {
            this.setBitmap(R.drawable.jumpbtn2);
        } else {
            this.setBitmap(R.drawable.jumpbtn1);
        }
    }

}
