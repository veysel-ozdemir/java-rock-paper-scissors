package com.pismamo.rockpaperscissorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView enemy_score, my_score, enemy_choice;
    Button button_rock, button_paper, button_scissor;
    int enemyScore = 0, myScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enemy_score = findViewById(R.id.textViewEnemyScore);
        my_score = findViewById(R.id.textViewMyScore);
        enemy_choice = findViewById(R.id.textViewEnemyChoice);
        button_rock = findViewById(R.id.buttonRock);
        button_paper = findViewById(R.id.buttonPaper);
        button_scissor = findViewById(R.id.buttonScissor);
    }

    public void buttonClick(View view) {
        switch (view.getId())
        {
            case R.id.buttonRock:
                start(1);
                break;
            case R.id.buttonPaper:
                start(2);
                break;
            case R.id.buttonScissor:
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
                (enemyChoice == 2 && myChoice == 2) ||
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