package com.example.nnguy637.journey;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;


/**
 * Created by nnguy637 on 12/11/2015.
 */
public class AddMilestoneFragment extends Fragment {


    private Milestones mMilestone;

    private Button mSubmit;
    private EditText mGoalEdit;
    private String mGoal;
    private Project mProject;


    @Override
    public void onCreate(Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_milestone, container, false);

        mGoalEdit = (EditText)v.findViewById(R.id.milestone_goal);
        mGoalEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               mGoal = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        mSubmit = (Button)v.findViewById(R.id.submit_button);
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {

                mMilestone = new Milestones(UUID.randomUUID());

                mMilestone.setProjectId(ProjectFragment.projectId.toString());
                mMilestone.setGoal(mGoal);
                mMilestone.setIsCompleted("false");
                MilestoneManager.get(getActivity()).addMilestone(mMilestone);

                getActivity().finish();
            }
        });
        return v;

    }
}