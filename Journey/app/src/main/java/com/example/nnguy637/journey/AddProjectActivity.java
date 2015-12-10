package com.example.nnguy637.journey;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by nnguy637 on 12/6/2015.
 * Mdoified by Jack Brody on 12/8/2015
 */
public class AddProjectActivity extends Activity {

    private static final String ARG_PROJECT_ID = "projectId";
    private static final String DIALOG_DATE = "DialogDate";
    private static final int REQUEST_DATE = 0;
    private Project mProject;
    private EditText mTitleField;
    private Button mStartDateButton;
    private Button mEndDateButton;
    private CheckBox mSolvedCheckbox;


    public static Intent newIntent(Context packageContext)
    {
        Intent i = new Intent(packageContext, AddProjectActivity.class);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add_project);
    }
}
