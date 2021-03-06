package com.example.halukcan.bitirmetezi;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnaSayfaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_sayfa);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Button basla = (Button) findViewById(R.id.basla);
        Button cikis = (Button) findViewById(R.id.cikis);

        basla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent basla = new Intent(AnaSayfaActivity.this,sayfa2.class);
                startActivity(basla);
            }
        });
        cikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.finishAffinity(AnaSayfaActivity.this);
            }
        });
    }
}
