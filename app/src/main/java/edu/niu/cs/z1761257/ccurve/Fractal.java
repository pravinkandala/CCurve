package edu.niu.cs.z1761257.ccurve;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Pravin on 4/5/16.
 */
public class Fractal {

public void drawCCurve(Canvas canvas, float x1, float y1, float x2, float y2, int level, int lineColor){

    //Create a Paint object
    Paint paint = new Paint();
    paint.setColor(lineColor);
    paint.setStrokeWidth(1);

    //base case for recursion
    if(level == 0){
        canvas.drawLine(x1,y1,x2,y2,paint);
    }
    //recursive step
    else{

        //calculating midpoint
        float xn = (x1+x2)/2 + (y1-y2)/2;
        float yn = (x1-x2)/2 + (y1+y2)/2;

        drawCCurve(canvas, x1, y1, xn, yn, level-1, lineColor);
        drawCCurve(canvas, xn, yn,x2, y2, level-1, lineColor);
    }



}//end of drawCurve


}//end of Fractal
