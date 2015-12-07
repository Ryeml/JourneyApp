package com.example.nnguy637.journey;



import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;


public class MainActivity extends FragmentActivity {

    ProjectListFragment mProjectListFragment;
    ButtonsFragment mButtonsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProjectListFragment = new ProjectListFragment();
        mButtonsFragment = new ButtonsFragment();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.add(R.id.projectListPanel, mProjectListFragment);
        ft.add(R.id.buttonsPanel, mButtonsFragment);

        ft.commit();
    }



}
