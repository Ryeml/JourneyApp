package com.example.nnguy637.journey;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Created by nnguy637 on 12/6/2015.
 */
public class Project {

    private UUID mID;

    private String mProjectTitle;
    private String mProjectDescription;
    private Date mStartDate;
    private Date mEndDate;

    public Project()
    {
        this(UUID.randomUUID());
    }

    public Project(UUID id)
    {
        mID = id;
    }

    public UUID getID() {
        return mID;
    }

    public String getProjectTitle() {
        return mProjectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        mProjectTitle = projectTitle;
    }

    public String getProjectDescription() {
        return mProjectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        mProjectDescription = projectDescription;
    }

    public Date getEndDate() {
        return mEndDate;
    }

    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }

    public Date getStartDate() {
        return mStartDate;
    }

    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    public void setID(UUID ID) {
        mID = ID;
    }

}
