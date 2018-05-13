package com.halukcanbalbay.mobilprog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.halukcanbalbay.mobilprog.VT.VTBaglanti;

import org.w3c.dom.Text;

import java.util.Calendar;

public class todo_app extends AppCompatActivity {


    private static final String TAG = "todo_app";

    private Button btnOlustur;
    int mGun, mAy,mYil, mSaat, mDakika;
    private TextView tarihSec, saatSec;
    private EditText yapilacak;
    private DatePickerDialog.OnDateSetListener tarihDinleyici;

    private RadioButton radBtn1, radBtn2, radBtn3;
    public int oncelik;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_app);

        initComponents();
        setTarihSec();
        setSaatSec();


        radBtn1.setChecked(true);
        oncelik=1;
        oncelikSecimi();

    }

    public void onClickAddTask (View view) {
        String input =yapilacak.getText().toString();
        String mTarih = tarihSec.getText().toString();
        String mSaat = saatSec.getText().toString();
        if (input.length()==0){
            return;
        }
        ContentValues veriEkle = new ContentValues();
        veriEkle.put(VTBaglanti.TaskEntry.COLUMN_DESCRIPTION, input);
        veriEkle.put(VTBaglanti.TaskEntry.COLUMN_PRIORITY, oncelik);
        veriEkle.put(VTBaglanti.TaskEntry.COLUMN_DATE,mTarih);
        veriEkle.put(VTBaglanti.TaskEntry.COLUMN_TIME,mSaat);

        Uri uri = getContentResolver().insert(VTBaglanti.TaskEntry.CONTENT_URI, veriEkle);

        if (uri != null){

            Toast.makeText(getBaseContext(),uri.toString(),Toast.LENGTH_SHORT).show();

        }
        finish();
    }

    public void setTarihSec(){
        tarihSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar takvim = Calendar.getInstance();
                mGun = takvim.get(Calendar.DAY_OF_MONTH);
                mAy = takvim.get(Calendar.MONTH);
                mYil = takvim.get(Calendar.YEAR);

                DatePickerDialog dialog = new DatePickerDialog(
                        todo_app.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,tarihDinleyici,mYil,mAy,mGun
                );
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        tarihDinleyici = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                String monthToString = String.valueOf(month);
                String dayToString = String.valueOf(dayOfMonth);

                month++;
                if(month < 10)
                    monthToString = "0" + month;
                if(dayOfMonth < 10) {
                    dayToString= "0" + dayOfMonth;}



            Log.d(TAG, "Tarih Secildiginde: tarih: " + year +"/"+ monthToString +"/"+ dayToString);

            String date = dayToString +"/"+ monthToString +"/"+ year;
            tarihSec.setText(date);
            }
        };
    }

    public void setSaatSec(){
        saatSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar saat = Calendar.getInstance();
                mSaat = saat.get(Calendar.HOUR_OF_DAY);
                mDakika = saat.get(Calendar.MINUTE);
                TimePickerDialog timeDialog;
                timeDialog = new TimePickerDialog(todo_app.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        String minToString = String.valueOf(minute);
                        String hourToString = String.valueOf(hourOfDay);

                        if (minute < 10 )
                            minToString = "0" + minute;
                        if (hourOfDay <  10 )
                            hourToString = "0" + hourOfDay;

                        saatSec.setText(hourToString+ ":" + minToString);
                    }
                },mSaat,mDakika,true);
                timeDialog.setTitle(mSaat+":"+mDakika);
                timeDialog.show();
            }
        });

    }

    public void oncelikSecimi(){
        if (radBtn1.isChecked()){
            oncelik = 1;
        }
        else if (radBtn2.isChecked()){
            oncelik = 2;
        }
        else if (radBtn3.isChecked()){
            oncelik = 3;
        }
    }

    public void initComponents(){

        btnOlustur = findViewById(R.id.button4);
        tarihSec = findViewById(R.id.textView4);
        saatSec = findViewById(R.id.textView5);
        radBtn1 = findViewById(R.id.radioButton);
        radBtn2 = findViewById(R.id.radioButton2);
        radBtn3 = findViewById(R.id.radioButton3);
        yapilacak = findViewById(R.id.editText2);

    }
}
