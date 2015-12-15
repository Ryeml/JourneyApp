package com.example.nnguy637.journey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by nnguy637 on 12/11/2015.
 */
public class AddProjectFragment extends Fragment {

    private Project mProject;

    private EditText mProjectTitleEdit;
    private String mProjectTitle;
    private EditText mProjectDescriptionEdit;
    private String mProjectDescription;
    private Button mStartDateButton;
    private Date mStartDate;
    private Button mEndDateButton;
    private Date mEndDate;

    private Button mSubmitProject;

    private boolean isDateError;


    private static final String DIALOG_DATE = "DialogDate";

    private static final int REQUEST_START_DATE = 0;
    private static final int REQUEST_END_DATE = 1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_project, container, false);

        mProjectTitleEdit = (EditText) v.findViewById(R.id.journey_title);
        mProjectTitleEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               mProjectTitle = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mProjectDescriptionEdit = (EditText)v.findViewById(R.id.journey_description);
        mProjectDescriptionEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mProjectDescription = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mStartDateButton = (Button) v.findViewById(R.id.journey_begin);
        mStartDate = new Date();
        mStartDateButton.setText("Choose a starting date");
        mStartDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                DatePickerFragment dialog = DatePickerFragment
                        .newInstance(mStartDate);
                dialog.setTargetFragment(AddProjectFragment.this, REQUEST_START_DATE);
                dialog.show(manager, DIALOG_DATE);
            }
        });

        mEndDateButton = (Button) v.findViewById(R.id.journey_end);
        mEndDate = new Date();
        mEndDateButton.setText("Choose an ending date");
        mEndDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                DatePickerFragment dialog = DatePickerFragment
                        .newInstance(mEndDate);
                dialog.setTargetFragment(AddProjectFragment.this, REQUEST_END_DATE);
                dialog.show(manager, DIALOG_DATE);
            }
        });

        mSubmitProject = (Button)v.findViewById(R.id.submit_journey);
        mSubmitProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProject = new Project(UUID.randomUUID(), new ArrayList<Milestones>());
                mProject.setProjectTitle(mProjectTitle);
                mProject.setProjectDescription(mProjectDescription);
                mProject.setStartDate(mStartDate);
                mProject.setEndDate(mEndDate);

                //prevents selecting end dates before start dates
                if(mProject.getStartDate().after(mProject.getEndDate()))
                {
                    isDateError = true;
                }
                else
                {
                    isDateError = false;
                }
                if (isDateError) {
                    Toast toast = Toast.makeText(getContext() , "There is an error in selecting dates", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    ProjectManager.get(getActivity()).addProject(mProject);
                    getActivity().finish();
                }
            }
        });

        return v;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_START_DATE) {
            Date date = (Date) data
                    .getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            mStartDate = date;
            updateStartDate();
        }
        else if(requestCode == REQUEST_END_DATE)
        {
            Date date = (Date) data
                    .getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            mEndDate = date;
            updateEndDate();
        }
    }

    private void updateStartDate() {
        mStartDateButton.setText(mStartDate.toString());
    }

    private void updateEndDate() {
        mEndDateButton.setText(mEndDate.toString());
    }
}

