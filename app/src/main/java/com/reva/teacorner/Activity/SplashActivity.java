package com.reva.teacorner.Activity;

import static com.reva.teacorner.FixValue.IN_lOGIN;
import static com.reva.teacorner.FixValue.MyPREFERENCES;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;

import com.reva.teacorner.R;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Timer timer= new Timer();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        TimerTask showsplash= new TimerTask() {
            @Override
            public void run() {
                SharedPreferences sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

                final SharedPreferences.Editor editor = sharedpreferences.edit();

                if (sharedpreferences != null || !sharedpreferences.equals("")) {

                    String b = sharedpreferences.getString(IN_lOGIN, "");
                    //String skip = sharedpreferences.getString(IN_SKIP, "");

                  /*  if (b.equalsIgnoreCase("isfirstime")) {
                        Intent intent1 = new Intent(SplashActivity.this, HmeActivity.class);
                        startActivity(intent1);
                        finish();

                    }*/




                    if (b.equalsIgnoreCase("")) {

                        Intent intent2 = new Intent(SplashActivity.this, KhataActivity.class);
                        startActivity(intent2);
                        finish();

                    }  if (b.equalsIgnoreCase("login")) {
                        Intent intent2 = new Intent(SplashActivity.this, KhataActivity.class);
                        startActivity(intent2);
                        finish();

                    }
                }






            }
        };
        // Start the timer
        timer.schedule(showsplash, 3000);
    }
}