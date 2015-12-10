package com.example.nnguy637.journey;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    private Button mDeleteButton;
    private UUID projectId;
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
        projectId = (UUID)getArguments().getSerializable(ARG_PROJECT_ID);
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

        mDeleteButton =(Button)v.findViewById(R.id.delete_project_button);
        mDeleteButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                AlertDialog.Builder delete_confirm = new AlertDialog.Builder(getContext());
                delete_confirm.setMessage("Delete this project?");
                delete_confirm.setCancelable(true);
                delete_confirm.setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                ProjectManager.get(getActivity()).deleteProject(projectId.toString());
                                dialog.cancel();
                                //after confirming deletion, go back to project list page
                                getActivity().finish();
                            }
                        });
                delete_confirm.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = delete_confirm.create();
                alert11.show();
            }
        });

        //credit to StackOverFlow user @IndexOutOfBounds
        //randomizes fragment background color
        int[] androidColors = getResources().getIntArray(R.array.androidcolors);
        int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)];
        v.setBackgroundColor(randomAndroidColor);

        return v;
    }
}
