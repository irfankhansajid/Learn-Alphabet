package com.android.learnalphabetwithfun;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Game2 extends AppCompatActivity implements View.OnClickListener{

    Button opt1, opt2, opt3, opt4;
    ImageButton imageRefresh;
    MediaPlayer audio;
    int count = 0;
    String comb1 = "DASYNFYLSPNQYQGWGPSSZNZHXAR";
    String comb2 = "KRTRALSFNOXNMXVAWEUPSWFRJHQ";
    String comb3 = "PQFECMKELVCJNPCWKNQBIIKGNRO";
    String comb4 = "WZYZQRJIQBKPVOBFRYRURKQJOYW";
    String ans =   "DQTZARYFLVCNMXBAWEUPSIKGJHO";
    int[] id = {R.raw.d,R.raw.q,R.raw.t,R.raw.z,R.raw.a,R.raw.r,R.raw.y,R.raw.f,
            R.raw.l,R.raw.v,R.raw.c,R.raw.n,R.raw.m,R.raw.x,R.raw.b,R.raw.a,R.raw.w,
            R.raw.e,R.raw.u,R.raw.p,R.raw.s,R.raw.i,R.raw.k,R.raw.g,R.raw.j,R.raw.h,R.raw.o};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        opt1 = findViewById(R.id.opt1);
        opt2 = findViewById(R.id.opt2);
        opt3 = findViewById(R.id.opt3);
        opt4 = findViewById(R.id.opt4);

        imageRefresh = findViewById(R.id.imageRefresh);

        audio = MediaPlayer.create(this, id[count]);

        opt1.setText(Character.toString(comb1.charAt(count)));
        opt2.setText(Character.toString(comb2.charAt(count)));
        opt3.setText(Character.toString(comb3.charAt(count)));
        opt4.setText(Character.toString(comb4.charAt(count)));

        opt1.setOnClickListener(this);
        opt2.setOnClickListener(this);
        opt3.setOnClickListener(this);
        opt4.setOnClickListener(this);
        imageRefresh.setOnClickListener(v -> audio.start());
    }

    @Override
    public void onClick(View view) {
        Button b = (Button) view;
        String s = b.getText().toString();
        String st = Character.toString(ans.charAt(count));

        if (s.compareTo(st)==0) {
            count++;
            if (count == 26) {
                count = 0;
            }
            opt1.setText(Character.toString(comb1.charAt(count)));
            opt2.setText(Character.toString(comb2.charAt(count)));
            opt3.setText(Character.toString(comb3.charAt(count)));
            opt4.setText(Character.toString(comb4.charAt(count)));

            audio = MediaPlayer.create(this, id[count]);
            audio.start();
        }
        else {
            Toast.makeText(this, "Wrong Answer...Replay the audio", Toast.LENGTH_SHORT).show();
        }

    }
}