package com.example.vivek.musicalstructures;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class player extends AppCompatActivity {

    int score;
    int images[] = {R.drawable.soorma_antham, R.drawable.karhar, R.drawable.dilgallan, R.drawable.halfgirl, R.drawable.harrymet,
            R.drawable.hindimed, R.drawable.mererashke, R.drawable.padmavat, R.drawable.sonu, R.drawable.sweetydrama};
    int names[] = {R.string.sing7, R.string.sing9, R.string.sing10, R.string.sing6, R.string.sing3, R.string.sing8, R.string.sing1,
            R.string.sing4, R.string.sing2, R.string.sing5};
    int song[] = {R.string.song1, R.string.song2, R.string.song3, R.string.song4, R.string.song5, R.string.song6, R.string.song7,
            R.string.song8, R.string.song9, R.string.song10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player);

        // receive the list item position and display albumArt info
        score = getIntent().getIntExtra("score", 0);
        final ImageView image = findViewById(R.id.gif);
        image.setImageResource(images[score]);

        final TextView text = findViewById(R.id.playing);
        text.setText(song[score]);

        final TextView txt = findViewById(R.id.artz);
        txt.setText(names[score]);

        // finding Image resource ids for play, pause and forward, backward buttons respectively
        final ImageButton image1 = findViewById(R.id.play);
        final ImageButton image2 = findViewById(R.id.pause);
        final ImageButton image3 = findViewById(R.id.forward);
        final ImageButton image4 = findViewById(R.id.backward);

        // rotation animation for albumArt
        final RotateAnimation rotateAnimation = new RotateAnimation(0, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);

        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(4000);
        rotateAnimation.setRepeatCount(Animation.INFINITE);

        findViewById(R.id.gif).startAnimation(rotateAnimation);

        // stop animaton for albumart
        final RotateAnimation pauseAnimation = new RotateAnimation(0, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);

        pauseAnimation.setInterpolator(new LinearInterpolator());
        pauseAnimation.setDuration(0);
        pauseAnimation.setRepeatCount(Animation.INFINITE);

        // action of onClick attribute of pause button
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.gif).startAnimation(rotateAnimation);
                // pause button disabled
                image1.setVisibility(View.INVISIBLE);
                // play button enabled
                image2.setVisibility(View.VISIBLE);
                Toast toast = Toast.makeText(getApplicationContext(), "Muzik Player Resumed", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }
        });

        // action of onClick attribute of play button
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.gif).startAnimation(pauseAnimation);
                // pause button disabled
                image2.setVisibility(View.INVISIBLE);
                // play button enabled
                image1.setVisibility(View.VISIBLE);
                Toast toast = Toast.makeText(getApplicationContext(), "Muzik Player Paused", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }
        });

        // action of onClick attribute of forward button
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (score != 9) {
                    score++;
                    findViewById(R.id.gif).startAnimation(rotateAnimation);
                    image.setImageResource(images[score]);
                    // play button disabed
                    image1.setVisibility(View.INVISIBLE);
                    // pause button enabled
                    image2.setVisibility(View.VISIBLE);
                    text.setText(song[score]);
                    txt.setText(names[score]);
                    Toast toast = Toast.makeText(getApplicationContext(), "Playing Next Song In Playlist", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                } else if (score == 9) {
                    score = 0;
                    findViewById(R.id.gif).startAnimation(rotateAnimation);
                    image.setImageResource(images[score]);
                    // play button disabled
                    image1.setVisibility(View.INVISIBLE);
                    // pause button enabled
                    image2.setVisibility(View.VISIBLE);
                    text.setText(song[score]);
                    txt.setText(names[score]);
                    Toast toast = Toast.makeText(getApplicationContext(), "Playing Next Song In Playlist", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
            }
        });

        // action of onClick attribute of backward button
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (score != 0) {
                    score--;
                    findViewById(R.id.gif).startAnimation(rotateAnimation);
                    image.setImageResource(images[score]);
                    // play button disabled
                    image1.setVisibility(View.INVISIBLE);
                    // pause button enabled
                    image2.setVisibility(View.VISIBLE);
                    text.setText(song[score]);
                    txt.setText(names[score]);
                    Toast toast = Toast.makeText(getApplicationContext(), "Playing Previous Song in Playlist", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                } else if (score == 0) {
                    score = 9;
                    findViewById(R.id.gif).startAnimation(rotateAnimation);
                    image.setImageResource(images[score]);
                    // play button disabled
                    image1.setVisibility(View.INVISIBLE);
                    // pause button enabled
                    image2.setVisibility(View.VISIBLE);
                    text.setText(song[score]);
                    txt.setText(names[score]);
                    Toast toast = Toast.makeText(getApplicationContext(), "Playing Previous Song in Playlist", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.show();
                }
            }
        });
    }
}