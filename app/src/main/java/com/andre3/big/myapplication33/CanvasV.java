package com.andre3.big.myapplication33;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by ODBBROW on 9/12/2016.
 */
public class CanvasV extends View {


    public CanvasV(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        int width = this.getWidth();
        int height = this.getHeight();
        int radius = width > height ? height/2 : width/2;

        int center_x = width/2;
        int center_y = height/2;
        Paint mPaint = new Paint();
        // prepare a paint
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPaint.setAntiAlias(true);
        System.out.println( center_x + radius );
        // draw a rectangle
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL); //fill the background with blue color
        canvas.drawRect(center_x - radius, center_y - radius , center_x + radius, height, mPaint); //left, top, right, bottom
        // draw some text and rotation
        mPaint.setTextSize(50);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setColor(Color.BLACK);
        canvas.drawText( "Hello World" , center_x , center_y, mPaint);
    }
}
