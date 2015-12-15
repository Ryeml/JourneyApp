package com.example.nnguy637.journey;

import java.util.UUID;

/**
 * Created by nnguy637 on 12/7/2015.
 */

public class Milestones {

    public UUID mMileStoneId;

    private String mGoal;

    public String getProjectId() {
        return mProjectId;
    }

    public void setProjectId(String projectId) {
        mProjectId = projectId;
    }

    public UUID getMileStoneId() {
        return mMileStoneId;
    }

    public void setMileStoneId(UUID mileStoneId) {
        mMileStoneId = mileStoneId;
    }

    public String getIsCompleted() {
        return mIsCompleted;
    }

    public void setIsCompleted(String isCompleted) {
        mIsCompleted = isCompleted;
    }

    public String getGoal() {
        return mGoal;
    }

    public void setGoal(String goal) {
        mGoal = goal;
    }

    private String mProjectId;
    private String mIsCompleted;

    public Milestones()
    {
        this(UUID.randomUUID());
    }

    public Milestones(UUID id)
    {
        mMileStoneId = id;
    }




}
