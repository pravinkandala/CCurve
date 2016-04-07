package edu.niu.cs.z1761257.ccurve;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

/**
 * Created by Pravin on 4/5/16.
 */
public class FractalView extends View {

    private float x1,y1,x2, y2;
    private int level, fractalColor;
    private Fractal fractal;

    public FractalView(Context context){
        super(context);
        setLevel(1);
        setFractalColor(Color.rgb(255, 0, 0));
        fractal = new Fractal();
    }//end of FractalView constructor

    public void setLevel(int newLevel){
        level = newLevel;
    }

    public void setFractalColor(int newColor){
        fractalColor = newColor;
    }

    protected void onDraw(Canvas canvas){
        //start coordinates
        x1 = canvas.getWidth()/3;
        y1 = canvas.getHeight()/4;

        //end coordinates
        x2 = canvas.getWidth() - x1;
        y2 = y1; //straight line

        //fill canvas with white
        canvas.drawRGB(255,255,255);

        //draw the fractal
        fractal.drawCCurve(canvas,x1,y1,x2,y2,level,fractalColor);
    }//end of onDraw
}//end of FractalView
