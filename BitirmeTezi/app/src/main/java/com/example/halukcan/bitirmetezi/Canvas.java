package com.example.halukcan.bitirmetezi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class Canvas extends View{
    float xPos , yPos;
    Paint paint;
    Path path;
    veriKaynagi veriKaynagi;
    dokunma d = new dokunma("Dokunma",1,1,1);

    public Canvas(Context context, @Nullable AttributeSet attrs) {

        super(context, attrs);
        paint=new Paint();
        path=new Path();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(9f);
    }
    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        xPos = event.getX();
        yPos = event.getY();
        Log.d("Dokunma  ","X:"+ xPos +" Y:" +yPos);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(xPos,yPos);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(xPos,yPos);
                break;
            case MotionEvent.ACTION_UP:
                break;

            default:
                return false;
        }
        this.invalidate();
        return true;
    }
    public void clearCanvas() {
        path.reset();
        invalidate();
    }
    public void backgroundCanvas(){
        backgroundCanvas();
    }
}
