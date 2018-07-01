package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.android.quizapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selections();
        Log.v("Quiz app", " oncreate " + maxPoints);
    }

    int maxPoints = 0;
    boolean errorChecker = false; //This iis to prevent multiple clicks

    /*******
     * Method called when each answer is selected
     */

    public void submitAnswers(View view) {
        //Check whether all answers were entered correctly
        EditText presidentName = (EditText) findViewById(R.id.name_of_buyer);
        String president = presidentName.getText().toString();
        String nyerere = "Nyerere";

        if (president.toLowerCase().contains(nyerere.toLowerCase())) {
            maxPoints += 1;
            Log.v("Quiz app", " nyerere " + maxPoints);
        } else {
            maxPoints -= 0;
            Log.v("Quiz app", " not nyerere " + maxPoints);
        }
        Log.v("Quiz app", " after nyerere " + maxPoints);
        evaluateAnswers();
    }

    //Check answers entered via the radio button

    // Check the radio button for Nigeria
    public void selections() {
        RadioGroup nigeria = (RadioGroup) findViewById(R.id.radio_nigeria);
        nigeria.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.v("Quiz app", " checkedID " + checkedId);
                if (checkedId == R.id.radioBuhari) {
                    maxPoints += 1;
                    Log.v("Quiz app", " buhari " + maxPoints);
                } else {
                    maxPoints -= 0;
                    Log.v("Quiz app", " not buhari " + maxPoints);
                }
            }

        });
        // Check the radio button for Mozambique
        RadioGroup mozambique = (RadioGroup) findViewById(R.id.radio_Mozambique);
        mozambique.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.radioNyusi) {
                    maxPoints += 1;
                    Log.v("Quiz app", " nyusi " + maxPoints);
                } else {
                    maxPoints -= 0;
                    Log.v("Quiz app", " not nyusi " + maxPoints);
                }
            }

        });
        // Check the radio button for Malawi
        RadioGroup malawi = (RadioGroup) findViewById(R.id.radio_Malawi);
        malawi.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.radioMutharika) {
                    maxPoints += 1;
                    Log.v("Quiz app", " mutharika " + maxPoints);
                } else {
                    maxPoints -= 0;
                    Log.v("Quiz app", " not mutharika " + maxPoints);
                }

            }
        });

        RadioGroup burundi = (RadioGroup) findViewById(R.id.radio_Burundi);
        burundi.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.radioNkurunzinza) {
                    maxPoints += 1;
                    Log.v("Quiz app", " nkurunzinza " + maxPoints);
                } else {
                    maxPoints -= 0;
                    Log.v("Quiz app", " not nkurunzinza " + maxPoints);
                }
            }
        });
        //Check if any of radio buttons are unselected
        if ((nigeria.getCheckedRadioButtonId() == -1) || (mozambique.getCheckedRadioButtonId() == -1) || (malawi.getCheckedRadioButtonId() == -1) || (burundi.getCheckedRadioButtonId() == -1)) {
            Toast.makeText(getApplicationContext(),
                    "Some questions are unanswered", Toast.LENGTH_SHORT).show();
            maxPoints = 0;
            errorChecker = true;
            return;

        } else {
            errorChecker = false;
        }

        //Get answers from checkboxes
        CheckBox togoSelection = findViewById(R.id.togo_checkbox);
        CheckBox cameroonSelection = findViewById(R.id.cameroon_checkbox);
        CheckBox lesothoSelection = findViewById(R.id.lesotho_checkbox);
        CheckBox angolaSelection = findViewById(R.id.angola_checkbox);

        boolean togo = togoSelection.isChecked();
        boolean cameroon = cameroonSelection.isChecked();
        boolean lesotho = lesothoSelection.isChecked();
        boolean angola = angolaSelection.isChecked();

        if ((togo == true)&& (cameroon == true)&&(lesotho==false)&&angola==false){
            maxPoints += 1;
        }else if ((togo == false)&& (cameroon == false)&&(lesotho==false)&&angola==false){
            errorChecker = true;
        }

    }
    /*******
     *
     * Restore all inputs to their initial values
     */
    public void clearInputs(View view){
        //Uncheck all radio buttons
        ((RadioGroup) findViewById(R.id.radio_nigeria)).clearCheck();
        ((RadioGroup)findViewById(R.id.radio_Burundi)).clearCheck();
        ((RadioGroup)findViewById(R.id.radio_Malawi)).clearCheck();
        ((RadioGroup)findViewById(R.id.radio_Mozambique)).clearCheck();

        //Clear the edit text input
        EditText textInput = (EditText) findViewById(R.id.name_of_buyer);
        textInput.getText().clear();

        //uncheck all checkboxes
        CheckBox togoSelection = findViewById(R.id.togo_checkbox);
        CheckBox cameroonSelection = findViewById(R.id.cameroon_checkbox);
        CheckBox lesothoSelection = findViewById(R.id.lesotho_checkbox);
        CheckBox angolaSelection = findViewById(R.id.angola_checkbox);
        togoSelection.setChecked(false);
        cameroonSelection.setChecked(false);
        lesothoSelection.setChecked(false);
        angolaSelection.setChecked(false);

        //Reset points to zero
        maxPoints = 0;
    }

    //Output the results of the test
    public void evaluateAnswers() {
        selections();
        Log.v("Quiz app", " Toasting " + maxPoints);
        //Output the results only if there is no error in the inputs
        if (errorChecker == false) {
            Toast.makeText(getApplicationContext(),
                    "you got " + maxPoints + " correct out of " +6, Toast.LENGTH_SHORT).show();
            Log.v("Quiz app", " " + maxPoints);
            maxPoints = 0;
        }
    }

}
