package com.demonzblood.vitcgpacalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_GPA = "com.demonzblood.vitcgpacalculator.GPA";
    public final static String EXTRA_SUM = "com.demonzblood.vitcgpacalculator.SUM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText editText1 = (EditText) findViewById(R.id.editText1);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);
        final EditText editText3 = (EditText) findViewById(R.id.editText3);
        final EditText editText4 = (EditText) findViewById(R.id.editText4);
        final EditText editText5 = (EditText) findViewById(R.id.editText5);
        final EditText editText6 = (EditText) findViewById(R.id.editText6);
        final EditText editText7 = (EditText) findViewById(R.id.editText7);
        final EditText editText8 = (EditText) findViewById(R.id.editText8);
        final EditText editText9 = (EditText) findViewById(R.id.editText9);
        final EditText editText10 = (EditText) findViewById(R.id.editText10);
        final EditText editText11 = (EditText) findViewById(R.id.editText11);
        final EditText editText12 = (EditText) findViewById(R.id.editText12);
        final EditText editText13 = (EditText) findViewById(R.id.editText13);
        final EditText editText14 = (EditText) findViewById(R.id.editText14);
        final EditText editText15 = (EditText) findViewById(R.id.editText15);
        final EditText editText16 = (EditText) findViewById(R.id.editText16);
        final EditText editText17 = (EditText) findViewById(R.id.editText17);
        final EditText editText18 = (EditText) findViewById(R.id.editText18);
        final EditText editText19 = (EditText) findViewById(R.id.editText19);
        final EditText editText20 = (EditText) findViewById(R.id.editText20);
        Button calculateGpa = (Button) findViewById(R.id.calculateGpa);

        calculateGpa.setOnClickListener(new View.OnClickListener() {

            double[] credits = new double[10];
            double[] grades = new double[10];
            double sum = 0;
            double gpa = 0;
            public void onClick(View v) {
                credits[0] = Double.parseDouble(editText1.getText().toString());
                credits[1] = Double.parseDouble(editText2.getText().toString());
                credits[2] = Double.parseDouble(editText3.getText().toString());
                credits[3] = Double.parseDouble(editText4.getText().toString());
                credits[4] = Double.parseDouble(editText5.getText().toString());
                credits[5] = Double.parseDouble(editText6.getText().toString());
                credits[6] = Double.parseDouble(editText7.getText().toString());
                credits[7] = Double.parseDouble(editText8.getText().toString());
                credits[8] = Double.parseDouble(editText9.getText().toString());
                credits[9] = Double.parseDouble(editText10.getText().toString());

                for(double i : credits) {
                    sum += i;
                }

                grades[0] = gradeToNumber(editText11.getText().toString().toUpperCase());
                grades[1] = gradeToNumber(editText12.getText().toString().toUpperCase());
                grades[2] = gradeToNumber(editText13.getText().toString().toUpperCase());
                grades[3] = gradeToNumber(editText14.getText().toString().toUpperCase());
                grades[4] = gradeToNumber(editText15.getText().toString().toUpperCase());
                grades[5] = gradeToNumber(editText16.getText().toString().toUpperCase());
                grades[6] = gradeToNumber(editText17.getText().toString().toUpperCase());
                grades[7] = gradeToNumber(editText18.getText().toString().toUpperCase());
                grades[8] = gradeToNumber(editText19.getText().toString().toUpperCase());
                grades[9] = gradeToNumber(editText20.getText().toString().toUpperCase());

                for(int j=0; j<10; j++) {
                    gpa += ((credits[j]/sum) * grades[j]);
                }

                Intent intent = new Intent(getApplicationContext(), GPAActivity.class);
                intent.putExtra(EXTRA_GPA, gpa);
                intent.putExtra(EXTRA_SUM, sum);
                startActivity(intent);
            }
        }
        );
    }

    public double gradeToNumber(String grade) {
        switch(grade) {
            case "S": return 10;
            case "A": return 9;
            case "B": return 8;
            case "C": return 7;
            case "D": return 6;
            case "E": return 5;
            case "F": return 0;
            case "N": return 0;
            case "NA": return 0;
            default: return 0;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
