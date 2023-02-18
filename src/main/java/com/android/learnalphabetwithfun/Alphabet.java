package com.android.learnalphabetwithfun;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Alphabet extends AppCompatActivity implements View.OnClickListener{
    ImageButton previous, refresh, next;
    TextView text;
    int count;
    MediaPlayer audio;
    int[] id = {R.raw.a,R.raw.b,R.raw.c,R.raw.d,R.raw.e,R.raw.f,R.raw.g,R.raw.h,R.raw.i,
            R.raw.j,R.raw.k,R.raw.l,R.raw.m,R.raw.n,R.raw.o,R.raw.p,R.raw.q,R.raw.r,R.raw.s,
            R.raw.t,R.raw.u,R.raw.v,R.raw.w,R.raw.x,R.raw.y,R.raw.z};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);

        previous = findViewById(R.id.previous);
        refresh = findViewById(R.id.refresh);
        next = findViewById(R.id.next);
        text = findViewById(R.id.letter);


        audio = MediaPlayer.create(this, id[count]);
        audio.start();

        previous.setOnClickListener(this);
        refresh.setOnClickListener(this);
        next.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.next) {
            if (count != 25) {
                audio.stop();
                count++;
                text.setText(alphabet(count));
                audio = MediaPlayer.create(this, id[count]);
                audio.start();
            }
            else {
                Toast.makeText(this, "Clicked previous button", Toast.LENGTH_SHORT).show();
            }
        }
        else if (view.getId() == R.id.previous) {
            if (count != 0) {
                count--;
                text.setText(alphabet(count));
            }
            else {
                Toast.makeText(this, "Clicked next button", Toast.LENGTH_SHORT).show();
            }
        }
        else if (view.getId() == R.id.refresh) {
            audio.start();
        }
    }

    private String alphabet(int n) {
        char part1 = (char) ('A' + n);
        char part2 = (char) ('a' + n);
        String a1 = Character.toString(part1);
        String a2 = Character.toString(part2);
        String ans = a1 + " " + a2;
        return ans;
    }
}