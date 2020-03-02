package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView ivSplash = findViewById(R.id.ivSplash);
        TextView tvSplash = findViewById(R.id.tvSplash);
        TextView tvSubSplash = findViewById(R.id.tvSubSplash);
        Button btnGet = findViewById(R.id.btnGet);

        //Load animation
        Animation atg = AnimationUtils.loadAnimation(this, R.anim.atg);
        Animation btgone = AnimationUtils.loadAnimation(this, R.anim.btgone);
        Animation btgtwo = AnimationUtils.loadAnimation(this, R.anim.btgtwo);

        //Pass animation
        ivSplash.setAnimation(atg);
        tvSplash.setAnimation(btgone);
        tvSubSplash.setAnimation(btgone);
        btnGet.setAnimation(btgtwo);

        //passing event
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, StopWatchActivity.class);
                intent2.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent2);
            }
        });



        //import font
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(), "fonts/MRegular.ttf");
        //customize font
        tvSplash.setTypeface(MRegular);
        tvSubSplash.setTypeface(MLight);
        btnGet.setTypeface(MMedium);
    }
}
