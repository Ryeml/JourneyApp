package Database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.nnguy637.journey.Project;

import java.util.Date;
import java.util.UUID;

/**
 * Created by nnguy637 on 12/8/2015.
 */
public class ProjectCursorWrapper extends CursorWrapper {
    public ProjectCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Project getProject() {
        String uuidString = getString(getColumnIndex(ProjectDbSchema.ProjectTable.Cols.UUID));
        String title = getString(getColumnIndex(ProjectDbSchema.ProjectTable.Cols.TITLE));
        String description = getString(getColumnIndex(ProjectDbSchema.ProjectTable.Cols.DESCRIPTION));
        long start_date = getLong(getColumnIndex(ProjectDbSchema.ProjectTable.Cols.START_DATE));
        long end_date = getLong(getColumnIndex(ProjectDbSchema.ProjectTable.Cols.END_DATE));

        Project project = new Project(UUID.fromString(uuidString));
        project.setProjectTitle(title);
        project.setProjectDescription(description);
        project.setStartDate(new Date(start_date));
        project.setEndDate(new Date(end_date));

        return project;
    }
}
