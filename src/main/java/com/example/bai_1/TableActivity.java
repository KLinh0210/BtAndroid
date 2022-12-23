package com.example.bai_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TableLayout;

import java.util.Random;

public class TableActivity extends AppCompatActivity {
    private static final String TAG2 = TableActivity.class.getName();
    private TableLayout table_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);

        Button change = (Button) findViewById(R.id.change3);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TableActivity.this, MainActivity.class));
            }
        });

        table_layout = (TableLayout) findViewById(R.id.table_layout);
        SeekBar seek2= (SeekBar) findViewById(R.id.seekBar2);
        seek2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                for (int i = 0; i < table_layout.getChildCount(); i++) {
                    View child = table_layout.getChildAt(i);
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
}