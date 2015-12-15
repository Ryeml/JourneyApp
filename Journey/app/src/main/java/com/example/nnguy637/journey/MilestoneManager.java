package com.example.nnguy637.journey;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import Database.MilestoneBaseHelper;
import Database.MilestoneDbSchema;
import Database.MilestonesCursorWrapper;

/**
 * Created by nnguy637 on 12/11/2015.
 */
public class MilestoneManager {

    private static MilestoneManager sMilestoneManager;

    private Context mContext;
    private SQLiteDatabase mDatabase;


    public static MilestoneManager get(Context context) {
        if (sMilestoneManager == null) {
            sMilestoneManager = new MilestoneManager(context);
        }
        return sMilestoneManager;
    }


    private MilestoneManager(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new MilestoneBaseHelper(mContext).getWritableDatabase();
    }

    //returns list of milestones that belong to the current project fragment id
    public List<Milestones> getMilestones() {
        List<Milestones> milestones = new ArrayList<>();
        MilestonesCursorWrapper cursor = queryMilestones(MilestoneDbSchema.MilestonesTable.Cols.PROJECT_ID + " = ?",
                new String[]{ProjectFragment.projectId.toString()});

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                milestones.add(cursor.getMilestone());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return milestones;
    }

    public Milestones getMilestone(UUID id) {
        MilestonesCursorWrapper cursor = queryMilestones(
                MilestoneDbSchema.MilestonesTable.Cols.UUID + " = ?",
                new String[]{id.toString()}
        );
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getMilestone();
        } finally {
            cursor.close();
        }
    }


    private static ContentValues getContentValues(Milestones milestone) {
        ContentValues values = new ContentValues();
        values.put(MilestoneDbSchema.MilestonesTable.Cols.UUID, milestone.getMileStoneId().toString());
        values.put(MilestoneDbSchema.MilestonesTable.Cols.PROJECT_ID, milestone.getProjectId());
        values.put(MilestoneDbSchema.MilestonesTable.Cols.MILESTONE_GOAL, milestone.getGoal());
        values.put(MilestoneDbSchema.MilestonesTable.Cols.IS_COMPLETED, milestone.getIsCompleted());


        return values;
    }
    private MilestonesCursorWrapper queryMilestones(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                MilestoneDbSchema.MilestonesTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null // orderBy
        );
        return new MilestonesCursorWrapper(cursor);
    }

    public void addMilestone(Milestones m) {
        ContentValues values = getContentValues(m);
        mDatabase.insert(MilestoneDbSchema.MilestonesTable.NAME, null, values);
    }


    public void updateMilestones(Milestones milestone) {
        String uuidString =milestone.getMileStoneId().toString();
        ContentValues values = getContentValues(milestone);

        mDatabase.update(MilestoneDbSchema.MilestonesTable.NAME, values,
               MilestoneDbSchema.MilestonesTable.Cols.UUID + " = ?",
                new String[]{uuidString});
    }


}
