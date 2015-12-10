package com.example.nnguy637.journey;

import java.util.Date;
import java.util.UUID;

/**
 * Created by nnguy637 on 12/7/2015.
 */

public class Milestones {

    //milestone Id
    private UUID mMileStoneId;
    //project Id that the milestone belongs to
    private UUID mProjectId;

    public Date getMSStartDate() {
        return mMSStartDate;
    }

    public void setMSStartDate(Date MSStartDate) {
        mMSStartDate = MSStartDate;
    }

    public Date getMSEndDate() {
        return mMSEndDate;
    }

    public void setMSEndDate(Date MSEndDate) {
        mMSEndDate = MSEndDate;
    }

    public UUID getMileStoneId() {
        return mMileStoneId;
    }

    public void setMileStoneId(UUID mileStoneId) {
        mMileStoneId = mileStoneId;
    }

    public String getMileStoneGoal() {
        return mMileStoneGoal;
    }

    public void setMileStoneGoal(String mileStoneGoal) {
        mMileStoneGoal = mileStoneGoal;
    }

    public boolean isCompleted() {
        return mIsCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        mIsCompleted = isCompleted;
    }

    private String mMileStoneGoal;
    //limit MS SD and ED between ranges of Project start and end dates
    private Date mMSStartDate;
    private Date mMSEndDate;
    private boolean mIsCompleted;


}
