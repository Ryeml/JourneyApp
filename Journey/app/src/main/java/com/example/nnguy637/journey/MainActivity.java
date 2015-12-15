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

        ft.add(R.id.project_list_fragment, mProjectListFragment, "ProjectListFragment");
        ft.add(R.id.buttons_fragment, mButtonsFragment, "ButtonsFragment");

        ft.commit();
    }



}
