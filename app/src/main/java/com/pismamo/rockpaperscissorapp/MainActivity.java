package com.pismamo.rockpaperscissorapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView enemy_score, my_score;
    ImageView enemy_choice, my_choice;
    ImageButton button_rock, button_paper, button_scissor;
    Button button_restart, button_exit;
    int enemyScore = 0, myScore = 0, win = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enemy_score = findViewById(R.id.textViewEnemyScore);
        my_score = findViewById(R.id.textViewMyScore);
        enemy_choice = findViewById(R.id.imageViewEnemyChoice);
        my_choice = findViewById(R.id.imageViewMyChoice);
        button_rock = findViewById(R.id.buttonRock);
        button_paper = findViewById(R.id.buttonPaper);
        button_scissor = findViewById(R.id.buttonScissor);
        button_restart = findViewById(R.id.buttonRestart);
        button_exit = findViewById(R.id.buttonExit);
        //Anonymous Event
        button_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enemyScore = 0;
                myScore = 0;
                enemy_score.setText("0");
                my_score.setText("0");
                enemy_choice.setImageResource(R.drawable.bluepill);
                my_choice.setImageResource(R.drawable.redpill);
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
                my_choice.setImageResource(R.drawable.rock);
                start(1);
                break;
            case R.id.buttonPaper:
                my_choice.setImageResource(R.drawable.paper);
                start(2);
                break;
            case R.id.buttonScissor:
                my_choice.setImageResource(R.drawable.scissor);
                start(3);
                break;
        }
    }

    public void start(int myChoice) {
        int enemyChoice = (int)(Math.random()*3+1);

        if(enemyChoice == 1)
            enemy_choice.setImageResource(R.drawable.rock);
        if(enemyChoice == 2)
            enemy_choice.setImageResource(R.drawable.paper);
        if(enemyChoice == 3)
            enemy_choice.setImageResource(R.drawable.scissor);

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
        if(enemyScore == win || myScore == win)
        {
            alertMessage();
        }
    }

    public void alertMessage() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        if(enemyScore == win)
        {
            dialog.setIcon(R.drawable.herobrine);
            dialog.setTitle("UNFORTUNATELY, YOU LOST!");
            dialog.setMessage("Enemy Score: "+enemyScore+"\nYour Score: "+myScore+"\nWanna take revenge?");
            dialog.setCancelable(false);
            dialog.setPositiveButton("LET'S DO IT!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    enemyScore = 0;
                    myScore = 0;
                    enemy_score.setText("0");
                    my_score.setText("0");
                    enemy_choice.setImageResource(R.drawable.bluepill);
                    my_choice.setImageResource(R.drawable.redpill);
                }
            });
            dialog.setNegativeButton("NOPE", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    System.exit(0);
                }
            });
            dialog.show();
        }
        else
        {
            dialog.setIcon(R.drawable.trophy);
            dialog.setTitle("CONGRATS, YOU WON!");
            dialog.setMessage("Enemy Score: "+enemyScore+"\nYour Score: "+myScore+"\nWanna win one more time?");
            dialog.setCancelable(false);
            dialog.setPositiveButton("SURE!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    enemyScore = 0;
                    myScore = 0;
                    enemy_score.setText("0");
                    my_score.setText("0");
                    enemy_choice.setImageResource(R.drawable.bluepill);
                    my_choice.setImageResource(R.drawable.redpill);
                }
            });
            dialog.setNegativeButton("NEXT TIME", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    System.exit(0);
                }
            });
            dialog.show();
        }
    }
}