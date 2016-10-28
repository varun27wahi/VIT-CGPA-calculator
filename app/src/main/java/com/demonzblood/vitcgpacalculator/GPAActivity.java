package com.demonzblood.vitcgpacalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GPAActivity extends AppCompatActivity {

    public final static String EXTRA_CGPA = "com.demonzblood.vitcgpacalculator.CGPA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView currGpa = (TextView) findViewById(R.id.currGpa);
        Button calculateCGPA = (Button) findViewById(R.id.calculateCgpa);

        final double gpa = getIntent().getDoubleExtra(MainActivity.EXTRA_GPA, 0);
        final double sum = getIntent().getDoubleExtra(MainActivity.EXTRA_SUM, 0);
        final double gpar = Math.round(gpa * 100.0) / 100.0;
        String gpaText = String.valueOf(gpar);
        currGpa.setText(gpaText);

        calculateCGPA.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                double cgpa;
                EditText prevCgpa = (EditText) findViewById(R.id.prevCgpa);
                EditText totalCredits = (EditText) findViewById(R.id.totalCredits);
                double tCredits = Double.parseDouble(totalCredits.getText().toString());
                double pCgpa = Double.parseDouble(prevCgpa.getText().toString());
                cgpa = (((tCredits - sum) / tCredits) * pCgpa) + ((sum / tCredits) * gpa);
                cgpa = Math.round(cgpa * 100.0) / 100.0;

                Intent intent = new Intent(getApplicationContext(), CGPAActivity.class);
                intent.putExtra(EXTRA_CGPA, cgpa);
                startActivity(intent);
            }
        }
        );
    }
}
