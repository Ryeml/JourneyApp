package com.example.nnguy637.journey;


import android.support.v4.app.Fragment;

/**
 * Created by nnguy637 on 12/6/2015.
 * Modified by Jack Brody on 12/8/2015
 */
public class AddProjectActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment()
    {
        return new AddProjectFragment();
    }


}
