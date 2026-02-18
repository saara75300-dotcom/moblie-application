package com.example.saraex6;

import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    ImageView i1;
    Button button;
    MediaPlayer m1;
    AnimationDrawable animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        i1 = findViewById(R.id.i1);

        m1 = MediaPlayer.create(this, R.raw.aud);

        animation = new AnimationDrawable();
        animation.addFrame(ContextCompat.getDrawable(this, R.drawable.img1), 2000);
        animation.addFrame(ContextCompat.getDrawable(this, R.drawable.img2), 2000);
        animation.addFrame(ContextCompat.getDrawable(this, R.drawable.img3), 2000);
        animation.addFrame(ContextCompat.getDrawable(this, R.drawable.img4), 2000);
        animation.addFrame(ContextCompat.getDrawable(this, R.drawable.img5), 2000);
        animation.setOneShot(false);

        button.setOnClickListener(v -> {
            i1.setImageDrawable(animation); // IMPORTANT FIX
            animation.start();

            if (m1 != null) {
                m1.start();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (m1 != null) {
            m1.release();
            m1 = null;
        }
    }
}
