package edu.niu.cs.z1761257.ccurve;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final static int MINIMUM_LEVEL = 1,
                     MAXIMUM_LEVEL = 14;
    private TextView levelTV;
    private Integer levelNum;
    private RelativeLayout relativeLayout;
    private FractalView fractalView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = (RelativeLayout)findViewById(R.id.screen);
        levelTV = (TextView)findViewById(R.id.levelNumberTextView);

        fractalView = new FractalView(this);
        relativeLayout.addView(fractalView, 0);
        levelNum = MINIMUM_LEVEL;
    }//end of onCreate

    //handle draw button
    public void drawFractal(View view){
        fractalView.setLevel(levelNum);
        fractalView.invalidate();
    }

    //handle + button
    public void stepUp(View view){
        if(levelNum<MAXIMUM_LEVEL){
            levelNum++;
            levelTV.setText(levelNum.toString());
        }
    }//stepUp

    //handle - button
    public void stepDown(View view){
        if(levelNum>MINIMUM_LEVEL){
            levelNum--;
            levelTV.setText(levelNum.toString());
        }
    }



}//end of MainActivity
