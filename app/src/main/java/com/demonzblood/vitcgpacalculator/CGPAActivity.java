package com.demonzblood.vitcgpacalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CGPAActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView finalCGPA = (TextView) findViewById(R.id.finalCGPA);
        Button shareButton = (Button) findViewById(R.id.shareButton);
        final double fCgpa = getIntent().getDoubleExtra(GPAActivity.EXTRA_CGPA, 0);
        String fCgpaText = String.valueOf(fCgpa);
        finalCGPA.setText(fCgpaText);

        shareButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "My predicted CGPA for next sem is " + fCgpa + "!");

                if(intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        }
        );
    }

}
