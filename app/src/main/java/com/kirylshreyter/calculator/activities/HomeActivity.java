package com.kirylshreyter.calculator.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.kirylshreyter.calculator.R;
import com.kirylshreyter.calculator.common.Constants;
import com.kirylshreyter.calculator.datamodel.ICalculator;
import com.kirylshreyter.calculator.datamodel.IDisplayResult;
import com.kirylshreyter.calculator.datamodel.impl.Calculator;
import com.kirylshreyter.calculator.exceptions.DivisionByZeroException;
import com.kirylshreyter.calculator.exceptions.MalformedExpressionException;

/**
 * Main {@link AppCompatActivity} of application.
 */
public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    ICalculator calculator = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setOnClickListeners();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_one:
                updateViews(calculator.one());
                break;
            case R.id.button_two:
                updateViews(calculator.two());
                break;
            case R.id.button_three:
                updateViews(calculator.three());
                break;
            case R.id.button_four:
                updateViews(calculator.four());
                break;
            case R.id.button_five:
                updateViews(calculator.five());
                break;
            case R.id.button_six:
                updateViews(calculator.six());
                break;
            case R.id.button_seven:
                updateViews(calculator.seven());
                break;
            case R.id.button_eight:
                updateViews(calculator.eight());
                break;
            case R.id.button_nine:
                updateViews(calculator.nine());
                break;
            case R.id.button_zero:
                updateViews(calculator.zero());
                break;
            case R.id.button_comma:
                updateViews(calculator.dot());
                break;
            case R.id.button_subtraction:
                updateViews(calculator.subtract());
                break;
            case R.id.button_addition:
                updateViews(calculator.add());
                break;
            case R.id.button_multiplication:
                updateViews(calculator.multiply());
                break;
            case R.id.button_division:
                updateViews(calculator.div());
                break;
            case R.id.button_remove_last_element:
                updateViews(calculator.removeLastElement());
                break;
            case R.id.button_switch_sign:
                updateViews(calculator.switchSign());
                break;
            case R.id.button_reset:
                updateViews(calculator.reset());
                break;
            case R.id.button_equality:
                try {
                    updateViews(calculator.result());
                } catch (MalformedExpressionException | DivisionByZeroException exception) {
                    updateErrorTextView(exception.getMessage());
                }
                break;
        }
    }


    private void updateViews(IDisplayResult result) {
        updateErrorTextView(Constants.EMPTY_STRING);
        updateResultTextView(result.getValue());
    }

    private void updateResultTextView(String value) {
        updateTextView(R.id.text_view_result, value);
    }

    private void updateErrorTextView(String value) {
        updateTextView(R.id.text_view_error, value);
    }

    private void updateTextView(int textViewId, String value) {
        ((TextView) findViewById(textViewId)).setText(value);
    }

    private void setOnClickListeners() {
        findViewById(R.id.button_one).setOnClickListener(this);
        findViewById(R.id.button_two).setOnClickListener(this);
        findViewById(R.id.button_three).setOnClickListener(this);
        findViewById(R.id.button_four).setOnClickListener(this);
        findViewById(R.id.button_five).setOnClickListener(this);
        findViewById(R.id.button_six).setOnClickListener(this);
        findViewById(R.id.button_seven).setOnClickListener(this);
        findViewById(R.id.button_eight).setOnClickListener(this);
        findViewById(R.id.button_nine).setOnClickListener(this);
        findViewById(R.id.button_zero).setOnClickListener(this);
        findViewById(R.id.button_comma).setOnClickListener(this);
        findViewById(R.id.button_subtraction).setOnClickListener(this);
        findViewById(R.id.button_addition).setOnClickListener(this);
        findViewById(R.id.button_multiplication).setOnClickListener(this);
        findViewById(R.id.button_division).setOnClickListener(this);
        findViewById(R.id.button_remove_last_element).setOnClickListener(this);
        findViewById(R.id.button_switch_sign).setOnClickListener(this);
        findViewById(R.id.button_reset).setOnClickListener(this);
        findViewById(R.id.button_equality).setOnClickListener(this);
    }
}
