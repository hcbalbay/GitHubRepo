package com.example.halukcan.bitirmetezi;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sayfa7 extends AppCompatActivity {

    Canvas canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayfa7);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        canvas = (Canvas) findViewById(R.id.altigen);
        Button ileri = (Button) findViewById(R.id.ileri);
        Button reset = (Button) findViewById(R.id.reset);

        ileri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ileri = new Intent(sayfa7.this, sayfa8.class);
                startActivity(ileri);
            }
        });
    }
    public void clearCanvas (View v){
        canvas.clearCanvas();
    }
}
