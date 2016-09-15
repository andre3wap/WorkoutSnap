package com.andre3.big.myapplication33;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ////setContentView(new CanvasV(this));

       /// ImageView img = (ImageView)findViewById(R.id.imageView);
        ////Bitmap data =  drawTextToBitmap(getApplicationContext(), R.drawable.ini, "Foook me");
        ////img.setImageBitmap(data);



                // Create fragment and give it an argument specifying the article it should show
                  ArticleFragment firstFragment = new ArticleFragment();

                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).commit();

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

            ///Typeface tf = Typeface.createFromAsset(getApplicationContext().getAssets(),"fonts/fontname.ttf");
            ///paint.setTypeface(tf);

            // draw text to the Canvas center
            Rect bounds = new Rect();
            paint.getTextBounds(mText, 0, mText.length(), bounds);
            int x = (bitmap.getWidth() - bounds.width())/6;
            int y = (bitmap.getHeight() + bounds.height())/5;

            Rect rf  = new Rect();

            paint.setColor(Color.parseColor("#000000"));
            canvas.drawRect(rf, paint);

            canvas.drawText(mText, x * scale, y * scale, paint);

            return bitmap;
        } catch (Exception e) {
            // TODO: handle exception



            return null;
        }

    }
}
