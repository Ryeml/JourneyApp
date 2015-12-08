package com.example.nnguy637.journey;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import java.util.Random;

/**
 * Created by nnguy637 on 12/6/2015.
 */
public class ProjectListFragment extends Fragment {

    private RecyclerView mProjectRecyclerView;
    private ProjectAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedStateInstance)
    {
        super.onCreate(savedStateInstance);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_project_list,container,false);
        mProjectRecyclerView = (RecyclerView)v.findViewById(R.id.project_recycler_view);
        mProjectRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

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
        ProjectManager pm = ProjectManager.get(getActivity());
        List<Project> projects = pm.getProjects();

        if(mAdapter == null) {
            mAdapter = new ProjectAdapter(projects);
            mProjectRecyclerView.setAdapter(mAdapter);
        }
            else {
            mAdapter.setProjects(projects);
            mAdapter.notifyDataSetChanged();
        }
    }

    private class ProjectHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private Project mProject;
        private TextView mProjectTitle;
        public ProjectHolder(View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);
            //set view objects
           mProjectTitle = (TextView)itemView.findViewById(R.id.item_project_title);
        }

        public void bindProject(Project project)
        {
            mProject = project;
            //bind them
            mProjectTitle.setText(mProject.getProjectTitle());

        }

        public void onClick(View v)
        {
            //show project details and activity to add milestones
            Intent intent = ProjectActivity.newIntent(getActivity(), mProject.getID());
            startActivity(intent);
        }


    }

    private class ProjectAdapter extends RecyclerView.Adapter<ProjectHolder> {

        private List<Project> mProjects;

        public ProjectAdapter(List<Project> projects)
        {
            mProjects = projects;
        }

        @Override
        public ProjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item_project, parent, false);
            return new ProjectHolder(view);
        }

        @Override
        public void onBindViewHolder(ProjectHolder holder, int position) {
            Project project = mProjects.get(position);
            holder.bindProject(project);
        }

        @Override
        public int getItemCount() {
            return mProjects.size();
        }

        public void setProjects(List<Project> projects)
        {
            mProjects = projects;
        }

    }
}
