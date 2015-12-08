package com.example.nnguy637.journey;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

/**
 * Created by nnguy637 on 12/7/2015.
 */
public class ProjectActivity extends SingleFragmentActivity{

    public static final String EXTRA_PROJECT_ID = "com.example.nnguy637.journey.project_id";

    public static Intent newIntent(Context packageContext, UUID projectId)
    {
        Intent intent = new Intent(packageContext, ProjectActivity.class);
        intent.putExtra(EXTRA_PROJECT_ID, projectId);
        return intent;
    }

    @Override
    protected Fragment createFragment()
    {
        UUID projectId = (UUID)getIntent().getSerializableExtra(EXTRA_PROJECT_ID);
        return ProjectFragment.newInstance(projectId);
    }

}
