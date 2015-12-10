package Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nnguy637 on 12/8/2015.
 */
public class ProjectBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "projectBase.db";

    public ProjectBaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE " + ProjectDbSchema.ProjectTable.NAME + "(" +
                "_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ProjectDbSchema.ProjectTable.Cols.UUID + ", " +
                ProjectDbSchema.ProjectTable.Cols.TITLE + ", " +
                ProjectDbSchema.ProjectTable.Cols.DESCRIPTION + ", " +
                ProjectDbSchema.ProjectTable.Cols.START_DATE + ", " +
                ProjectDbSchema.ProjectTable.Cols.END_DATE + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
