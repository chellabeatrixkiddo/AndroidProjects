package com.example.android.quizavengers;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    int points = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
    public void submitQuiz(View view) {
        // Retrieve all the answers entered by the user
        RadioGroup firstRadioGroup = (RadioGroup) findViewById(R.id.ques1_grp);
        int firstSelectedId = firstRadioGroup.getCheckedRadioButtonId();
        RadioButton firstOption = (RadioButton)findViewById(firstSelectedId);
        String firstAns = firstOption.getText().toString();
        Log.v("SecondActivity: ", "First Answer: " + firstAns);

        RadioGroup secondRadioGrp = (RadioGroup) findViewById(R.id.ques2_grp);
        int secondSelectedId = secondRadioGrp.getCheckedRadioButtonId();
        RadioButton secondOption = (RadioButton)findViewById(secondSelectedId);
        String secondAns = secondOption.getText().toString();
        Log.v("SecondActivity: ", "Second Answer: " + secondAns);

        EditText third = (EditText) findViewById(R.id.ques3_text);
        String thirdAns = third.getText().toString();
        Log.v("SecondActivity: ", "Third Answer: " + thirdAns);

        CheckBox fourthOption1 = (CheckBox) findViewById(R.id.ques4_cb1);
        CheckBox fourthOption2 = (CheckBox) findViewById(R.id.ques4_cb2);
        CheckBox fourthOption3 = (CheckBox) findViewById(R.id.ques4_cb3);
        boolean fourthAns1 = fourthOption1.isChecked();
        boolean fourthAns2 = fourthOption2.isChecked();
        boolean fourthAns3 = fourthOption3.isChecked();
        Log.v("SecondActivity: ", "Fourth Answer: " + fourthAns1 + ", " + fourthAns2 + ", " + fourthAns3);

        EditText fifth = (EditText) findViewById(R.id.ques5_text);
        String fifthAns = fifth.getText().toString();
        Log.v("SecondActivity: ", "Fifth Answer: " + fifthAns);

        // Check if the retrieved answers are all correct
        if(firstAns.equals("Nova Corps")) {
            points += 1;
            Log.v("SecondActivity: ", "Score until now: " + points);
        }

        if(secondAns.equals("Thor")){
            points += 1;
            Log.v("SecondActivity: ", "Score until now: " + points);
        }
        if(thirdAns.equalsIgnoreCase("Strategic Homeland Intervention Enforcement and Logistics Division")) {
            points += 1;
            Log.v("SecondActivity: ", "Score until now: " + points);
        }

        if(fourthAns1 && fourthAns2 && !fourthAns3) {
            points += 1;
            Log.v("SecondActivity: ", "Score until now: " + points);
        }

        if(fifthAns.equalsIgnoreCase("Red Room")) {
            points += 1;
            Log.v("SecondActivity: ", "Score until now: " + points);
        }
        Toast.makeText(SecondActivity.this,"Your Score: " + points,Toast.LENGTH_LONG).show();

    }
}
