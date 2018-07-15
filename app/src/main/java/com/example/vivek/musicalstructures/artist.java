package com.example.vivek.musicalstructures;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class artist extends AppCompatActivity {

    int score;
    int images[] = {R.drawable.nusrat, R.drawable.arjit, R.drawable.pritam, R.drawable.shreya, R.drawable.pawinni, R.drawable.ash,
            R.drawable.shankar, R.drawable.guru, R.drawable.sukh, R.drawable.atif};
    int names[] = {R.string.sing1, R.string.sing2, R.string.sing3, R.string.sing4, R.string.sing5, R.string.sing6, R.string.sing7,
            R.string.sing8, R.string.sing9, R.string.sing10};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artist);

        // receive the list item position and display artist info
        score = getIntent().getIntExtra("score", 0);
        ImageView image = findViewById(R.id.art);
        image.setImageResource(images[score]);

        //setting up customised toolbar (collapsing)
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolBar);
        toolbar.setTitle(names[score]);
    }
}
