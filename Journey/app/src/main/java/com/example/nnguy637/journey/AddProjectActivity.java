package com.example.nnguy637.journey;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by nnguy637 on 12/6/2015.
 */
public class AddProjectActivity extends Activity {

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
