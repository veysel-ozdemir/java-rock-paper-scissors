package com.pismamo.rockpaperscissorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView enemy_score, my_score, enemy_choice, my_choice;
    Button button_rock, button_paper, button_scissor, button_restart, button_exit;
    int enemyScore = 0, myScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enemy_score = findViewById(R.id.textViewEnemyScore);
        my_score = findViewById(R.id.textViewMyScore);
        enemy_choice = findViewById(R.id.textViewEnemyChoice);
        my_choice = findViewById(R.id.textViewMyChoice);
        button_rock = findViewById(R.id.buttonRock);
        button_paper = findViewById(R.id.buttonPaper);
        button_scissor = findViewById(R.id.buttonScissor);
        button_restart = findViewById(R.id.buttonRestart);
        button_exit = findViewById(R.id.buttonExit);
        //Anonymous Event
        button_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enemy_score.setText("0");
                my_score.setText("0");
                enemy_choice.setText("");
                my_choice.setText("");
                enemyScore = 0;
                myScore = 0;
            }
        });
        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }

    public void buttonClick(View view) {
        switch (view.getId())
        {
            case R.id.buttonRock:
                my_choice.setText("ROCK");
                start(1);
                break;
            case R.id.buttonPaper:
                my_choice.setText("PAPER");
                start(2);
                break;
            case R.id.buttonScissor:
                my_choice.setText("SCISSOR");
                start(3);
                break;
        }
    }

    public void start(int myChoice) {
        int enemyChoice = (int)(Math.random()*3+1);

        if(enemyChoice == 1)
            enemy_choice.setText("ROCK");
        if(enemyChoice == 2)
            enemy_choice.setText("PAPER");
        if(enemyChoice == 3)
            enemy_choice.setText("SCISSOR");

        if((enemyChoice == 1 && myChoice == 1) ||
                (enemyChoice == 2 && myChoice == 2) ||
                (enemyChoice == 3 && myChoice == 3))
        {
            Toast.makeText(this,"DRAW", Toast.LENGTH_SHORT).show();
        }
        else if((enemyChoice == 1 && myChoice == 3) ||
                (enemyChoice == 2 && myChoice == 1) ||
                (enemyChoice == 3 && myChoice == 2))
        {
            enemyScore++;
            enemy_score.setText(String.valueOf(enemyScore));
        }
        else
        {
            myScore++;
            my_score.setText(String.valueOf(myScore));
        }
    }
}