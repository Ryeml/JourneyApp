package Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nnguy637 on 12/11/2015.
 */
public class MilestoneBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "milestoneBase.db";

    public MilestoneBaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE " + Database.MilestoneDbSchema.MilestonesTable.NAME + "(" +
                "_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Database.MilestoneDbSchema.MilestonesTable.Cols.UUID + " , " +
                Database.MilestoneDbSchema.MilestonesTable.Cols.PROJECT_ID + " , " +
                Database.MilestoneDbSchema.MilestonesTable.Cols.MILESTONE_GOAL + " , " +
                Database. MilestoneDbSchema.MilestonesTable.Cols.IS_COMPLETED + ");");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
