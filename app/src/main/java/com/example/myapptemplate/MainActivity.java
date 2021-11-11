package com.example.myapptemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity {
    ProgressBar pbLoading;
    ImageView imgStart;
    int progress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbLoading=findViewById(R.id.pbLoading);
        imgStart=findViewById(R.id.imgStart);

        imgStart.setVisibility(View.INVISIBLE);
        progress=0;
        pbLoading.setProgress(progress);

        loading(150);
    }

    private void loading(int delay) {
        if (progress<100) {
            progress++;
            pbLoading.setProgress(progress);

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    loading(delay);
                }
            }, delay);
        }
        else {
            // show start button
            pbLoading.setVisibility(View.INVISIBLE);
            imgStart.setVisibility(View.VISIBLE);

            // start menu activity after progress bar is 100
            //openMenuActivity(null);
        }
    }

    public void openMenuActivity(View view) {
        Intent intent;
        intent = new Intent(this, MenuActivity.class);
        startActivity(intent);

        finish(); // close this main activity

    }
}