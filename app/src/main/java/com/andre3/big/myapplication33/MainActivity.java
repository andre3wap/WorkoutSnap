package com.andre3.big.myapplication33;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img = (ImageView)findViewById(R.id.imageView);

        Bitmap data =  drawTextToBitmap(getApplicationContext(), R.drawable.ini, "Foook me");

        img.setImageBitmap(data);
    }

    public Bitmap drawTextToBitmap(Context mContext, int resourceId, String mText) {
        try {

            Resources resources = mContext.getResources();
            float scale = resources.getDisplayMetrics().density;
            Bitmap bitmap = BitmapFactory.decodeResource(resources, resourceId);

            android.graphics.Bitmap.Config bitmapConfig =   bitmap.getConfig();
            // set default bitmap config if none
            if(bitmapConfig == null) {
                bitmapConfig = android.graphics.Bitmap.Config.ARGB_8888;
            }

            bitmap = bitmap.copy(bitmapConfig, true);

            Canvas canvas = new Canvas(bitmap);


            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            paint.setColor(Color.rgb(110,110, 110));
            paint.setTextSize((int) (12 * scale));
            ///paint.setTypeface(R.)

            // draw text to the Canvas center
            Rect bounds = new Rect();
            paint.getTextBounds(mText, 0, mText.length(), bounds);
            int x = (bitmap.getWidth() - bounds.width())/6;
            int y = (bitmap.getHeight() + bounds.height())/5;

            canvas.drawText(mText, x * scale, y * scale, paint);

            return bitmap;
        } catch (Exception e) {
            // TODO: handle exception



            return null;
        }

    }
}
