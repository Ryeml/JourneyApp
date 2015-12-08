package com.example.nnguy637.journey;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_project, container, false);

        mTitle = (TextView)v.findViewById(R.id.title_textView);
        mTitle.setText(mProject.getProjectTitle());

        mDescription=(TextView)v.findViewById(R.id.description_textView);
        mDescription.setText(mProject.getProjectDescription());

        mStartDate=(TextView)v.findViewById(R.id.start_date_textView);
        mStartDate.setText(mProject.getStartDate().toString());

        mEndDate=(TextView)v.findViewById(R.id.end_date_textView);
        mEndDate.setText(mProject.getEndDate().toString());

        return v;
    }
}
