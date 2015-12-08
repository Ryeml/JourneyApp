package com.example.nnguy637.journey;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import Database.ProjectBaseHelper;
import Database.ProjectCursorWrapper;
import Database.ProjectDbSchema;

/**
 * Created by nnguy637 on 12/7/2015.
 */
public class ProjectManager {

    private static ProjectManager sProjectManager;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    //singleton
    public static ProjectManager get(Context context) {
        if (sProjectManager == null) {
            sProjectManager = new ProjectManager(context);
        }
        return sProjectManager;
    }

    private ProjectManager(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new ProjectBaseHelper(mContext).getWritableDatabase();
    }

    public List<Project> getProjects() {
        List<Project> projects = new ArrayList<>();
        ProjectCursorWrapper cursor = queryProjects(null, null);

        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                projects.add(cursor.getProject());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return projects;
    }

    public Project getProject(UUID id) {
        ProjectCursorWrapper cursor = queryProjects(
                ProjectDbSchema.ProjectTable.Cols.UUID + " = ?",
                new String[]{id.toString()}
        );
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getProject();
        } finally {
            cursor.close();
        }
    }

    private static ContentValues getContentValues(Project project) {
        ContentValues values = new ContentValues();
        values.put(ProjectDbSchema.ProjectTable.Cols.UUID, project.getID().toString());
        values.put(ProjectDbSchema.ProjectTable.Cols.TITLE, project.getProjectTitle());
        values.put(ProjectDbSchema.ProjectTable.Cols.DESCRIPTION, project.getProjectDescription());
        values.put(ProjectDbSchema.ProjectTable.Cols.START_DATE, project.getStartDate().toString());
        values.put(ProjectDbSchema.ProjectTable.Cols.END_DATE, project.getEndDate().toString());

        return values;
    }

    private ProjectCursorWrapper queryProjects(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                ProjectDbSchema.ProjectTable.NAME,
                null, // Columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null, // having
                null // orderBy
        );
        return new ProjectCursorWrapper(cursor);
    }


    public void addProject(Project p) {
        ContentValues values = getContentValues(p);
        mDatabase.insert(ProjectDbSchema.ProjectTable.NAME, null, values);
    }

    public void updateProject(Project project) {
        String uuidString = project.getID().toString();
        ContentValues values = getContentValues(project);

        mDatabase.update(ProjectDbSchema.ProjectTable.NAME, values,
                ProjectDbSchema.ProjectTable.Cols.UUID + " = ?",
                new String[]{uuidString});
    }


}
