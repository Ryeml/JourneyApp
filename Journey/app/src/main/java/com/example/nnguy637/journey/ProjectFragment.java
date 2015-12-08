package com.example.nnguy637.journey;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;
import java.util.UUID;

/**
 * Created by nnguy637 on 12/7/2015.
 */
public class ProjectFragment extends Fragment {

    private Project mProject;
    private TextView mTitle;
    private TextView mDescription;
    private TextView mStartDate;
    private TextView mEndDate;

    private static final String ARG_PROJECT_ID = "project_id";

    public static ProjectFragment newInstance(UUID projectId)
    {
        Bundle args = new Bundle();
        args.putSerializable(ARG_PROJECT_ID, projectId);

        ProjectFragment fragment = new ProjectFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        UUID projectId = (UUID)getArguments().getSerializable(ARG_PROJECT_ID);
        mProject = ProjectManager.get(getActivity()).getProject(projectId);
    }

    @Override
    public void onPause()
    {
        super.onPause();
        ProjectManager.get(getActivity()).updateProject(mProject);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_project, container, false);

        mTitle = (TextView)v.findViewById(R.id.project_title);
        mTitle.setText(mProject.getProjectTitle());

        mDescription=(TextView)v.findViewById(R.id.project_description);
        mDescription.setText(mProject.getProjectDescription());

        mStartDate=(TextView)v.findViewById(R.id.project_start_date);
        mStartDate.setText(mProject.getStartDate().toString());

        mEndDate=(TextView)v.findViewById(R.id.project_end_date);
        mEndDate.setText(mProject.getEndDate().toString());

        //credit to StackOverFlow user @IndexOutOfBounds
        //randomizes fragment background color
        int[] androidColors = getResources().getIntArray(R.array.androidcolors);
        int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)];
        v.setBackgroundColor(randomAndroidColor);

        return v;
    }
}
