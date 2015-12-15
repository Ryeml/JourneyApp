package com.example.nnguy637.journey;

import android.support.v4.app.Fragment;

/**
 * Created by nnguy637 on 12/11/2015.
 */
public class AddMilestoneActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment()
    {
      return new AddMilestoneFragment();
    }
}
