package com.example.nnguy637.journey;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by nnguy637 on 12/7/2015.
 */
public class ProjectManager {

    private static ProjectManager sProjectManager;

    private ArrayList<Project> mProjects;

    //singleton
    public static ProjectManager get(Context context) {
        if (sProjectManager == null) {
            sProjectManager = new ProjectManager(context);
        }
        return sProjectManager;
    }

    private ProjectManager(Context context) {
        mProjects = new ArrayList<>();
        for(int i = 0;i<4;i++)
        {
            Project project = new Project();
            project.setProjectTitle("KUTTS");
            project.setProjectDescription("BUTTS");
            mProjects.add(project);
        }
    }

    public List<Project> getProjects() {
        return mProjects;
    }

    public Project getProject(UUID id) {
        for (Project project : mProjects) {
            if (project.getID().equals(id)) {
                return project;
            }
        }
        return null;
    }
}
