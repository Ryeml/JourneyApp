package com.example.nnguy637.journey;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * Created by nnguy637 on 12/6/2015.
 */
public class ButtonsFragment extends Fragment {

    public ImageView mAdd;
    public ImageView mSettings;

    @Override
    public void onCreate(Bundle savedStateInstance)
    {
        super.onCreate(savedStateInstance);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedStateInstance)
    {
        View v = inflater.inflate(R.layout.fragment_buttons, container, false);

        mAdd = (ImageView)v.findViewById(R.id.add_button);
        mAdd.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent i = new Intent(getActivity(), AddProjectActivity.class);
                startActivity(i);
            }
        });


        mSettings = (ImageView)v.findViewById(R.id.settings_button);
        mSettings.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent i = new Intent(getActivity(), SettingsActivity.class);
                startActivity(i);
            }
        });


        return v;
    }
}

