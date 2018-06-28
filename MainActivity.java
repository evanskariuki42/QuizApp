package com.example.android.quizapp;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.quizapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selections();

    }

    int maxPoints = 5;

    public void submitAnswers(View view) {
        //Check whether all answers were entered correctly
        EditText presidentName = (EditText) findViewById(R.id.name_of_buyer);
        String president = presidentName.getText().toString();
        String search  = "Nyerere";

        if ( president.toLowerCase().contains(search.toLowerCase()) ) {
            maxPoints -= 0;
            Log.v("Quiz app", " TZ "+ maxPoints);
        } else {
            maxPoints -= 1;
            Log.v("Quiz app", " TZ "+ maxPoints);
        }
        evaluateAnswers();
    }

    public void selections() {
        RadioGroup nigeria = (RadioGroup) findViewById(R.id.radio_nigeria);
        nigeria.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioYemi:
                        // do operations specific to this selection
                        maxPoints -= 1;
                        Log.v("Quiz app", " Yemi "+ maxPoints);
                        break;
                    case R.id.radioObasanjo:
                        // do operations specific to this selection
                        maxPoints -= 1;
                        Log.v("Quiz app", " Obasanjo "+ maxPoints);
                        break;
                    case R.id.radioBuhari:
                        // do operations specific to this selection
                        maxPoints += 0;
                        Log.v("Quiz app", " Buhari "+ maxPoints);
                        break;
                }
            }



        });

        RadioGroup mozambique = (RadioGroup) findViewById(R.id.radio_Mozambique);
        mozambique.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.radioNyusi:
                        // do operations specific to this selection
                        maxPoints -= 0;
                        Log.v("Quiz app", " Nyusi "+ maxPoints);
                        break;
                    case R.id.radioRosario:
                        // do operations specific to this selection
                        maxPoints -= 1;
                        Log.v("Quiz app", " Rosario "+ maxPoints);
                        break;
                    case R.id.radioSamora:
                        // do operations specific to this selection
                        maxPoints -= 1;
                        Log.v("Quiz app", " Samora "+ maxPoints);
                        break;
                }
            }

        });

        RadioGroup malawi = (RadioGroup) findViewById(R.id.radio_Malawi);
        malawi.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.radioMutharika:
                        // do operations specific to this selection
                        maxPoints -= 0;
                        Log.v("Quiz app", " Mutharika "+ maxPoints);
                        break;
                    case R.id.radioBanda:
                        // do operations specific to this selection
                        maxPoints -= 1;
                        Log.v("Quiz app", " Banda "+ maxPoints);
                        break;
                    case R.id.radioChakwera:
                        // do operations specific to this selection
                        maxPoints -= 1;
                        Log.v("Quiz app", " Chakwera "+ maxPoints);
                        break;
                }

            }
        });

        RadioGroup burundi = (RadioGroup) findViewById(R.id.radio_Burundi);
        burundi.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.radioNkurunzinza:
                        // do operations specific to this selection
                        maxPoints -= 0;
                        Log.v("Quiz app", " Nkurunzinza "+ maxPoints);
                        break;
                    case R.id.radioKagame:
                        // do operations specific to this selection
                        maxPoints -= 1;
                        Log.v("Quiz app", " kagame "+ maxPoints);
                        break;
                    case R.id.radioNdayieze:
                        // do operations specific to this selection
                        maxPoints -= 1;
                        Log.v("Quiz app", " ndayieze "+ maxPoints);
                        break;
                }
            }
        });

    }

    public void evaluateAnswers() {
        selections();
        Log.v("Quiz app", " Toasting "+ maxPoints);
        Toast.makeText(getApplicationContext(),
                "you got " + maxPoints + " correct", Toast.LENGTH_SHORT).show();
        Log.v("Quiz app", " "+ maxPoints);
    }

}
