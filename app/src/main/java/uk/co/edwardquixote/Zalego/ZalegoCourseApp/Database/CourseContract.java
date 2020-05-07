package uk.co.edwardquixote.Zalego.ZalegoCourseApp.Database;

import android.provider.BaseColumns;

public class CourseContract implements BaseColumns {

    public static final String COURSE_TABLE_NAME = "course";

    public static final String COLUMN_COURSE_TITLE = "course_title";
    public static final String COLUMN_COURSE_DESCRIPTION = "course_description";


    public static final String SQL_CREATE_TABLE_COURSE = "CREATE TABLE " + COURSE_TABLE_NAME + " ("
            + CourseContract._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_COURSE_TITLE + " TEXT, "
            + COLUMN_COURSE_DESCRIPTION + " TEXT)";

    public static final String SQL_DROP_TABLE_COURSE = "DROP TABLE IF EXISTS " + COURSE_TABLE_NAME;

}
