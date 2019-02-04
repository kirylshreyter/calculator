package com.kirylshreyter.calculator.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.kirylshreyter.calculator.R;
import com.kirylshreyter.calculator.common.Constants;
import com.kirylshreyter.calculator.datamodel.ICalculator;
import com.kirylshreyter.calculator.datamodel.impl.Calculator;
import com.kirylshreyter.calculator.exceptions.DivisionByZeroException;
import com.kirylshreyter.calculator.exceptions.MalformedExpressionException;
import com.kirylshreyter.calculator.tasks.UpdateTextViewErrorsTask;
import com.kirylshreyter.calculator.tasks.UpdateTextViewResultTask;

/**
 * Main {@link AppCompatActivity} of application.
 */
public class MainActivity extends AppCompatActivity {
    ICalculator calculator = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mButtonOne = findViewById(R.id.button_one);
        mButtonOne.setOnClickListener((View view) -> runTasks(calculator.one().value()));

        Button mButtonTwo = findViewById(R.id.button_two);
        mButtonTwo.setOnClickListener((View view) -> runTasks(calculator.two().value()));

        Button mButtonThree = findViewById(R.id.button_three);
        mButtonThree.setOnClickListener((View view) -> runTasks(calculator.three().value()));

        Button mButtonFour = findViewById(R.id.button_four);
        mButtonFour.setOnClickListener((View view) -> runTasks(calculator.four().value()));

        Button mButtonFive = findViewById(R.id.button_five);
        mButtonFive.setOnClickListener((View view) -> runTasks(calculator.five().value()));

        Button mButtonSix = findViewById(R.id.button_six);
        mButtonSix.setOnClickListener((View view) -> runTasks(calculator.six().value()));

        Button mButtonSeven = findViewById(R.id.button_seven);
        mButtonSeven.setOnClickListener((View view) -> runTasks(calculator.seven().value()));

        Button mButtonEight = findViewById(R.id.button_eight);
        mButtonEight.setOnClickListener((View view) -> runTasks(calculator.eight().value()));

        Button mButtonNine = findViewById(R.id.button_nine);
        mButtonNine.setOnClickListener((View view) -> runTasks(calculator.nine().value()));

        Button mButtonZero = findViewById(R.id.button_zero);
        mButtonZero.setOnClickListener((View view) -> runTasks(calculator.zero().value()));

        Button mButtonDot = findViewById(R.id.button_comma);
        mButtonDot.setOnClickListener((View view) -> runTasks(calculator.dot().value()));

        Button mButtonSubtraction = findViewById(R.id.button_subtraction);
        mButtonSubtraction.setOnClickListener((View view) -> runTasks(calculator.subtract().value()));

        Button mButtonAddition = findViewById(R.id.button_addition);
        mButtonAddition.setOnClickListener((View view) -> runTasks(calculator.add().value()));

        Button mButtonMultiplication = findViewById(R.id.button_multiplication);
        mButtonMultiplication.setOnClickListener((View view) -> runTasks(calculator.multiply().value()));

        Button mButtonDivision = findViewById(R.id.button_division);
        mButtonDivision.setOnClickListener((View view) -> runTasks(calculator.div().value()));

        Button mButtonRemoveLastElement = findViewById(R.id.button_remove_last_element);
        mButtonRemoveLastElement.setOnClickListener((View view) -> runTasks(calculator.removeLastElement().value()));

        Button mButtonSwitchSign = findViewById(R.id.button_switch_sign);
        mButtonSwitchSign.setOnClickListener((View view) -> runTasks(calculator.switchSign().value()));

        Button mButtonEquality = findViewById(R.id.button_equality);
        mButtonEquality.setOnClickListener((View view) -> {
            try {
                runTasks(calculator.result().value());
            } catch (MalformedExpressionException | DivisionByZeroException e) {
                new UpdateTextViewErrorsTask(e.getMessage()).execute(this);
            }
        });

        Button mButtonReset = findViewById(R.id.button_reset);
        mButtonReset.setOnClickListener((View view) -> runTasks(calculator.reset().value()));
    }

    private void runTasks(String value) {
        new UpdateTextViewErrorsTask(Constants.EMPTY_STRING).execute(this);
        new UpdateTextViewResultTask(value).execute(this);
    }
}
