package com.example.nnguy637.journey;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends FragmentActivity {

    ProjectListFragment mProjectListFragment;
    ButtonsFragment mButtonsFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProjectListFragment = new ProjectListFragment();
        mButtonsFragment = new ButtonsFragment();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.projectListPanel, mProjectListFragment, "ProjectListFragment");
        ft.add(R.id.buttonsPanel, mButtonsFragment, "ButtonsFragment");

        ft.commit();
    }



}
