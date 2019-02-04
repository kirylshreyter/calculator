package com.kirylshreyter.calculator.tasks;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import com.kirylshreyter.calculator.R;

/**
 * Class is used for updating error {@link TextView} of application.
 */
public class UpdateTextViewErrorsTask extends AsyncTask<Context, Void, Void> {
    private String resultString;

    /**
     * Main constructor for {@link UpdateTextViewErrorsTask}
     *
     * @param string {@link String} error text with which performing an update to view.
     */
    public UpdateTextViewErrorsTask(String string) {
        this.resultString = string;
    }

    @Override
    protected Void doInBackground(Context... contexts) {
        Activity activity = (Activity) contexts[0];
        TextView mTextViewResult = activity.findViewById(R.id.text_view_error);
        mTextViewResult.setText(resultString);
        return null;
    }
}
