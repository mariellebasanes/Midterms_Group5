package com.example.midterms_group5;

import android.graphics.Color; // Import Color class
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.midterms_group8.R;
import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText num1, num2, num3, num4, num5, num6;
    private TextView textView4, textView5, result; // Added result TextView
    private Button submitButton;
//test
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the input fields
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        num5 = findViewById(R.id.num5);
        num6 = findViewById(R.id.num6);

        // Initialize the TextViews for displaying results
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        result = findViewById(R.id.result); // Initialize result TextView

        // Initialize the Submit button
        submitButton = findViewById(R.id.button5);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateWinningNumbers();
            }
        });
    }

    private void generateWinningNumbers() {
        // Retrieve user input
        List<Integer> userNumbers = new ArrayList<>();
        userNumbers.add(Integer.parseInt(num1.getText().toString()));
        userNumbers.add(Integer.parseInt(num2.getText().toString()));
        userNumbers.add(Integer.parseInt(num3.getText().toString()));
        userNumbers.add(Integer.parseInt(num4.getText().toString()));
        userNumbers.add(Integer.parseInt(num5.getText().toString()));
        userNumbers.add(Integer.parseInt(num6.getText().toString()));

        // Generate random winning numbers
        HashSet<Integer> winningNumbers = new HashSet<>();
        Random random = new Random();

        while (winningNumbers.size() < 6) {
            winningNumbers.add(random.nextInt(49) + 1); // Generates a number from 1 to 49
        }

        // Display the winning numbers without brackets
        List<Integer> winningNumbersList = new ArrayList<>(winningNumbers);
        textView4.setText( winningNumbersList.toString().replaceAll("[\\[\\]]", "")); // Removes brackets
        textView5.setText("Your Numbers: " + userNumbers.toString().replaceAll("[\\[\\]]", "")); // Removes brackets

        // Check for matches
        boolean hasMatch = false;
        for (int userNumber : userNumbers) {
            if (winningNumbers.contains(userNumber)) {
                hasMatch = true;
                break;
            }
        }

        // Set message for result based on whether there is a match or not
        if (hasMatch) {
            result.setText("Congratulations! You have a winning number!");
            result.setTextColor(Color.parseColor("#4CAF50")); // Set color to red for no win using hex
        } else {
            result.setText("Sorry, no winning numbers. Better luck next time!");
            result.setTextColor(Color.parseColor("#FF0000")); // Set color to red for no win using hex
        }
    }
}
