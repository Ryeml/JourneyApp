package com.example.nnguy637.journey;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nnguy637 on 12/10/2015.
 */
public class MilestoneListFragment extends Fragment{

    private RecyclerView mMilestoneRecyclerView;
    private MilestoneAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedStateInstance)
    {
        super.onCreate(savedStateInstance);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_milestone_list, container, false);
        mMilestoneRecyclerView = (RecyclerView)v.findViewById(R.id.milestone_recycler_view);
        mMilestoneRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return v;
    }

    @Override
    public void onResume()
    {
        super.onResume();
        updateUI();
    }

    private void updateUI()
    {
        MilestoneManager mm = MilestoneManager.get(getActivity());
        List<Milestones> milestones = mm.getMilestones();

        if(mAdapter == null) {
            mAdapter = new MilestoneAdapter(milestones);
            mMilestoneRecyclerView.setAdapter(mAdapter);
        }
        else {
            mAdapter.setMilestones(milestones);
            mAdapter.notifyDataSetChanged();
        }
    }

    private class MilestoneHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Milestones mMilestone;
        private CheckBox mIsCompletedCheckBox;
        private TextView mMilestoneTitle;


        public MilestoneHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            //set view objects
            mMilestoneTitle = (TextView) itemView.findViewById(R.id.item_milestone_title);
            mIsCompletedCheckBox = (CheckBox)itemView.findViewById(R.id.isCompletedCheckBox);
            mIsCompletedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mMilestone.setIsCompleted("true");
                    mIsCompletedCheckBox.setEnabled(false);
                    MilestoneManager.get(getActivity()).updateMilestones(mMilestone);
                }
            });
        }


        public void bindMilestone(Milestones milestone) {
            mMilestone = milestone;

            mMilestoneTitle.setText(mMilestone.getGoal());

            if(mMilestone.getIsCompleted().equals("false")) {
                mIsCompletedCheckBox.setChecked(false);
            }
            else
            {
                mIsCompletedCheckBox.setChecked(true);
            }
        }

        public void onClick(View v)
        {
        }

    }

    private class MilestoneAdapter extends RecyclerView.Adapter<MilestoneHolder> {

        private List<Milestones> mMilestones;

        public MilestoneAdapter(List<Milestones> milestones)
        {
            mMilestones = milestones;
        }

        @Override
        public MilestoneHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_milestone, parent, false);
            return new MilestoneHolder(view);
        }

        @Override
        public void onBindViewHolder(MilestoneHolder holder, int position) {
            Milestones milestone = mMilestones.get(position);
            holder.bindMilestone(milestone);
        }

        @Override
        public int getItemCount() {
            return mMilestones.size();
        }

        public void setMilestones(List<Milestones> milestones)
        {
            mMilestones = milestones;
        }

    }
}

