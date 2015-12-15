package Database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.nnguy637.journey.Milestones;
import java.util.UUID;

/**
 * Created by nnguy637 on 12/11/2015.
 */
public class MilestonesCursorWrapper extends CursorWrapper {
    public MilestonesCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Milestones getMilestone() {
        String uuidString = getString(getColumnIndex(MilestoneDbSchema.MilestonesTable.Cols.UUID));
        String project_Id = getString(getColumnIndex(MilestoneDbSchema.MilestonesTable.Cols.PROJECT_ID));
        String goal = getString(getColumnIndex(MilestoneDbSchema.MilestonesTable.Cols.MILESTONE_GOAL));
        String isCompleted = getString(getColumnIndex(MilestoneDbSchema.MilestonesTable.Cols.IS_COMPLETED));


        Milestones milestone = new Milestones(UUID.fromString(uuidString));
        milestone.setProjectId(project_Id);
        milestone.setGoal(goal);
        milestone.setIsCompleted(isCompleted);
        return milestone;
    }
}
