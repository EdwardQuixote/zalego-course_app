package uk.co.edwardquixote.Zalego.ZalegoCourseApp.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CourseDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ZALEGO_COURSES";

    private static final int DATABASE_VERSION = 1;


    public CourseDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CourseContract.SQL_CREATE_TABLE_COURSE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(CourseContract.SQL_DROP_TABLE_COURSE);

        this.onCreate(db);

    }

}
