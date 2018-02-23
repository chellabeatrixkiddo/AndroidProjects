package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreA = 0;
    int scoreB = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * Displays the given score for Team A.
     */
    public void plusThreeA(View view) {
        scoreA += 3;
        displayForTeamA(scoreA);
    }
    public void plusTwoA(View view) {
        scoreA += 2;
        displayForTeamA(scoreA);
    }
    public void freeThrowA(View view) {
        scoreA += 1;
        displayForTeamA(scoreA);
    }
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Team B.
     */
    public void plusThreeB(View view) {
        scoreB += 3;
        displayForTeamA(scoreB);
    }
    public void plusTwoB(View view) {
        scoreB += 2;
        displayForTeamA(scoreB);
    }
    public void freeThrowB(View view) {
        scoreB += 1;
        displayForTeamA(scoreB);
    }
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    public void reset(View view) {
        scoreA = 0;
        scoreB = 0;
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
    }
}
