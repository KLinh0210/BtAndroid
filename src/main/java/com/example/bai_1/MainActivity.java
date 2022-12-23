package com.example.bai_1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bai_1.LinearActivity;

import com.example.bai_1.R;
import com.example.bai_1.MoreInformationDialog;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    private RelativeLayout palette;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button change = (Button) findViewById(R.id.change2);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LinearActivity.class));
            }
        });

        palette = (RelativeLayout) findViewById(R.id.palette);
        SeekBar seek= (SeekBar) findViewById(R.id.seekBar);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                for (int i = 0; i < palette.getChildCount(); i++) {
                    View child = palette.getChildAt(i);
                    int r = 0, g = 0, b = 0;
                    Random randomGenerator = new Random();
                    int randomInt = randomGenerator.nextInt(7);
                    if (randomInt == 0) {
                        r = 72;
                        g = 61;
                        b = 139;
                    }
                    if (randomInt == 1) {
                        r = 111;
                        g = 0;
                        b = 255;
                    }
                    if (randomInt == 2) {
                        r = g = 0;
                        b = 255;
                    }
                    if (randomInt == 3) {
                        r = 0;
                        g = 255;
                        b = 0;
                    }
                    if (randomInt == 4) {
                        r = 255;
                        g = 255;
                        b = 0;
                    }
                    if (randomInt == 5) {
                        r = 255;
                        g = 165;
                        b = 0;
                    }
                    if (randomInt == 6) {
                        r = 255;
                        g = b = 0;
                    }

                    int originalColor = Color.parseColor((String) child.getTag());
                    if (getResources().getColor(R.color.white) != originalColor) {
                        child.setBackgroundColor(Color.rgb(r, g, b));
                        child.invalidate();
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void showDialog(MenuItem menuItem){
        new MoreInformationDialog().show(getFragmentManager(), TAG);
    }
}