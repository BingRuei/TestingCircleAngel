package com.app.ray.testingcircleangel;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //取得main.xml內img1,img2的ImageView
        ImageView mImg1 = (ImageView) findViewById(R.id.img1);
        ImageView mImg2 = (ImageView) findViewById(R.id.img2);

        //將圖片及圓角數值帶入getRoundedCornerBitmap()並放入mImg1內
        mImg1.setImageBitmap(getRoundedCornerBitmap(
                BitmapFactory.decodeResource(
                        getResources(), R.mipmap.ic_launcher),50.0f));

        //將圖片及圓角數值帶入getRoundedCornerBitmap()並放入mImg2內
        mImg2.setImageBitmap(getRoundedCornerBitmap(
                BitmapFactory.decodeResource(
                        getResources(), R.mipmap.ic_launcher),100.0f));
    }

    //圓角轉換函式，帶入Bitmap圖片及圓角數值則回傳圓角圖，回傳Bitmap再置入ImageView
    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float roundPx)
    {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(),
                bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }
}