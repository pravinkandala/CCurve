package edu.niu.cs.z1761257.ccurve;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

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

        //Put toolbar on the screen
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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
      //  Toast.makeText(this,"working",Toast.LENGTH_SHORT).show();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }//end of onCreateOptionsMenu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.draw_black:
                fractalView.setFractalColor(Color.rgb(0,0,0));
                fractalView.invalidate();
                Toast.makeText(this, "Selected Black",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.draw_blue:
                fractalView.setFractalColor(Color.rgb(0, 0, 255));
                fractalView.invalidate();
                Toast.makeText(this, "Selected Blue",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.draw_red:
                fractalView.setFractalColor(Color.rgb(255,0,0));
                fractalView.invalidate();
                Toast.makeText(this, "Selected Red",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.draw_green:
                fractalView.setFractalColor(Color.rgb(0,255,0));
                fractalView.invalidate();
                Toast.makeText(this, "Selected Green",Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);


        }


    }//end of onOptionsItemSelected
}//end of MainActivity
