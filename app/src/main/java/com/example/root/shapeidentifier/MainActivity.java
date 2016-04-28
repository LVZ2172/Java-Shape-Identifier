package com.example.root.shapeidentifier;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clickCheck(View view) {
        Shape input = new Shape();

        EditText number = (EditText) findViewById(R.id.number);
        String numberStr = number.getText().toString();
        double numberDouble = (Double.parseDouble(numberStr));
        input.value = numberDouble;

        if (numberStr.isEmpty()) {
            Toast.makeText(getApplicationContext(), "cannot be blank!", Toast.LENGTH_SHORT).show();
        } else if (input.checkSquare() && input.checkTriangle()) {
            Toast.makeText(getApplicationContext(), "this number is a square and triangle", Toast.LENGTH_SHORT).show();
        } else if (input.checkSquare()) {
            Toast.makeText(getApplicationContext(), "this number is a square", Toast.LENGTH_SHORT).show();
        } else if (input.checkTriangle()) {
            Toast.makeText(getApplicationContext(), "this number is a triangle", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "this number is neither a square or triangle.", Toast.LENGTH_SHORT).show();
        }
    }

    class Shape {
        double value;

        public boolean checkSquare() {
            double sqrt = Math.sqrt(this.value);

            if (sqrt*sqrt == this.value) {
                return true;
          } else {
                return false;
          }
        }

        public boolean checkTriangle() {
           double x = 1;
            double triangularNumber = 1;

            while (triangularNumber < this.value) {
                x++;
                triangularNumber = triangularNumber + x;
            }

            if (triangularNumber == this.value) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
