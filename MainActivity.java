package com.example.android.footballcounter;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;     // Counts score of Team A
    int scoreTeamB = 0;     // Counts score of Team B
    int scoreTeamAUndo = 0;
    int scoreTeamBUndo = 0;
    int undoCount = 0;      // variable set to find last Action to undo


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hier habe ich ein Dropdown Menü erprobt
        spinnerUse();

    }

    /*
    Hier habe ich ein Dropdown Menü erprobt */

    public void spinnerUse () {
        Spinner dropDownA = (Spinner) findViewById(R.id.spinner_team_a);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.array_team_a, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        dropDownA.setAdapter(adapter);

        class SpinnerActivity extends Activity implements OnItemSelectedListener {


            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                parent.getItemAtPosition(2);
                // An item was selected. You can retrieve the selected item using
                // parent.getItemAtPosition(pos)
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        }
        dropDownA.setOnItemSelectedListener((OnItemSelectedListener) this);

    }


    /* Methods to add points to Team A's score */

    public void incrementSixForA(View view) {
        scoreTeamAUndo = scoreTeamA;
        scoreTeamA += 6;
        displayScoreTeamA(scoreTeamA);
        undoCount = 1;
    }

    public void incrementThreeForA(View view) {
        scoreTeamAUndo = scoreTeamA;
        scoreTeamA += 3;
        displayScoreTeamA(scoreTeamA);
        undoCount = 2;
    }

    public void incrementTwoForA(View view) {
        scoreTeamAUndo = scoreTeamA;
        scoreTeamA += 2;
        displayScoreTeamA(scoreTeamA);
        undoCount = 3;
    }

    public void incrementOneForA(View view) {
        scoreTeamAUndo = scoreTeamA;
        scoreTeamA += 1;
        displayScoreTeamA(scoreTeamA);
        undoCount = 4;
    }

    public void displayScoreTeamA(int currentScoreA) {
        TextView scoreA = (TextView) findViewById(R.id.score_team_a);
        scoreA.setText(String.valueOf(currentScoreA));
    }

    /* End of Methods for Team A scores */

    /* Methods to add points to Team B's score */

    public void incrementSixForB(View view) {
        scoreTeamBUndo = scoreTeamB;
        scoreTeamB += 6;
        displayScoreTeamB(scoreTeamB);
        undoCount = 5;
    }

    public void incrementThreeForB(View view) {
        scoreTeamBUndo = scoreTeamB;
        scoreTeamB += 3;
        displayScoreTeamB(scoreTeamB);
        undoCount = 6;
    }

    public void incrementTwoForB(View view) {
        scoreTeamBUndo = scoreTeamB;
        scoreTeamB += 2;
        displayScoreTeamB(scoreTeamB);
        undoCount = 7;
    }

    public void incrementOneForB(View view) {
        scoreTeamBUndo = scoreTeamB;
        scoreTeamB += 1;
        displayScoreTeamB(scoreTeamB);
        undoCount = 8;
    }

    public void displayScoreTeamB(int currentScoreB) {
        TextView scoreB = (TextView) findViewById(R.id.score_team_b);
        scoreB.setText(String.valueOf(currentScoreB));

       // resets the winner and loser text

        TextView winA = findViewById(R.id.winner_text_a);
        winA.setText("");
        winA.setBackgroundColor(Color.WHITE);

        TextView winB = findViewById(R.id.winner_text_b);
        winB.setText("");
        winB.setBackgroundColor(Color.WHITE);
    }


    /* End of Methods for Team A scores */


    /* Methods to display winner and loser */

    public void displayWinA(String winOfA) {
        TextView winA = findViewById(R.id.winner_text_a);
        winA.setText(winOfA);
        winA.setBackgroundColor(Color.GREEN);
    }

    public void displayLoseA(String loseOfA) {
        TextView loseA = findViewById(R.id.winner_text_a);
        loseA.setText(loseOfA);
        loseA.setBackgroundColor(Color.RED);
    }

    public void displayWinB(String winOfB) {
        TextView winB = findViewById(R.id.winner_text_b);
        winB.setText(winOfB);
        winB.setBackgroundColor(Color.GREEN);
    }

    public void displayLoseB(String loseOfB) {
        TextView loseB = findViewById(R.id.winner_text_b);
        loseB.setText(loseOfB);
        loseB.setBackgroundColor(Color.RED);
    }

    /* End of Methods to display winner and loser */


    /* Method to find winner */
    public void howWon(View view) {
        if (scoreTeamA > scoreTeamB) {
            displayWinA("Won");
            displayLoseB("Lost");
        }
        if (scoreTeamA < scoreTeamB) {
            displayWinB("Won");
            displayLoseA("Lost");
        }
        if (scoreTeamA == scoreTeamB) {
            displayWinB("Draw");
            displayWinA("Draw");
        }
    }


    /* Method to reset */
    public void resetScores(View view) {
        scoreTeamAUndo = scoreTeamA;
        scoreTeamBUndo = scoreTeamB;
        scoreTeamB = 0;
        scoreTeamA = 0;
        displayScoreTeamA(scoreTeamA);
        displayScoreTeamB(scoreTeamB);
        undoCount = 9;
    }


        /* Method undo last action */
    public void undoLastAction(View view) {
        switch(undoCount) {
            case 1:
                scoreTeamA = scoreTeamAUndo;
                displayScoreTeamA(scoreTeamA);
                break;
            case 2:
                scoreTeamA = scoreTeamAUndo;
                displayScoreTeamA(scoreTeamA);
                break;
            case 3:
                scoreTeamA = scoreTeamAUndo;
                displayScoreTeamA(scoreTeamA);
                break;
            case 4:
                scoreTeamA = scoreTeamAUndo;
                displayScoreTeamA(scoreTeamA);
                break;
            case 5:
                scoreTeamB = scoreTeamBUndo;
                displayScoreTeamB(scoreTeamB);
                break;
            case 6:
                scoreTeamB = scoreTeamBUndo;
                displayScoreTeamB(scoreTeamB);
                break;
            case 7:
                scoreTeamB = scoreTeamBUndo;
                displayScoreTeamB(scoreTeamB);
                break;
            case 8:
                scoreTeamB = scoreTeamBUndo;
                displayScoreTeamB(scoreTeamB);
                break;
            case 9:
                scoreTeamB = scoreTeamBUndo;
                scoreTeamA = scoreTeamAUndo;
                displayScoreTeamA(scoreTeamA);
                displayScoreTeamB(scoreTeamB);
                break;
        }
    }


}
