package com.example.halukcan.bitirmetezi;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class sayfa2 extends AppCompatActivity {
    private Bitmap bitmap;
    Canvas canvas;
    veriKaynagi vk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayfa2);
        vk = new veriKaynagi(this);
        vk.ac();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        canvas = (Canvas) findViewById(R.id.duzcizgi);
        Button ileri = (Button) findViewById(R.id.ileri);
        Button reset =(Button) findViewById(R.id.reset);

        final TextView textView = (TextView) findViewById(R.id.textView4);

        canvas.setDrawingCacheEnabled(true);
        canvas.buildDrawingCache(true);

        canvas.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {


                if (event.getAction()==MotionEvent.ACTION_DOWN || event.getAction()==MotionEvent.ACTION_MOVE){
                    bitmap = canvas.getDrawingCache();
                    int pixel = bitmap.getPixel((int) event.getX(),(int)event.getY());

                    int r = Color.red(pixel);
                    int g = Color.green(pixel);
                    int b = Color.blue(pixel);

                    textView.setBackgroundColor(Color.rgb(r,g,b));
                    textView.setText("R("+r+")\n"+"G("+g+")\n"+"B("+b+")");
                }

                return true;
            }
        });


        ileri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ileri = new Intent(sayfa2.this, sayfa3.class);
                startActivity(ileri);

            }
        });

    }
    public void clearCanvas (View v) {
        dokunma d = new dokunma("Dokunma",0,0,1);

        canvas.clearCanvas();

    }


   /* protected void onResume () {
        vk.ac();
        super.onResume();

    }
    protected void onPause () {
        vk.kapat();
        super.onPause();
    }*/
}
