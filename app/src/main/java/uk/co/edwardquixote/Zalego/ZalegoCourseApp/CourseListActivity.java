package uk.co.edwardquixote.Zalego.ZalegoCourseApp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import uk.co.edwardquixote.Zalego.ZalegoCourseApp.Adapters.AdapterCourseList;
import uk.co.edwardquixote.Zalego.ZalegoCourseApp.DataModels.ModelCourse;
import uk.co.edwardquixote.Zalego.ZalegoCourseApp.Database.CourseContract;
import uk.co.edwardquixote.Zalego.ZalegoCourseApp.Database.CourseDBHelper;

public class CourseListActivity extends AppCompatActivity {

    private List<ModelCourse> listOfSearchedCourses;

    private RecyclerView rvCourseList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        initializeViews();

    }


    private void initializeViews() {

        listOfSearchedCourses = new ArrayList<>();
        AdapterCourseList classAdapterCourseList = new AdapterCourseList(listOfSearchedCourses);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(CourseListActivity.this, LinearLayoutManager.VERTICAL, false);

        rvCourseList = (RecyclerView) this.findViewById(R.id.rvCourseList);
        rvCourseList.setHasFixedSize(true);
        rvCourseList.setLayoutManager(layoutManager);
        rvCourseList.setAdapter(classAdapterCourseList);

        FloatingActionButton fabAddCourse = (FloatingActionButton) this.findViewById(R.id.fabCourseList);
        fabAddCourse.setOnClickListener(clkCourseList);

        readAllCoursesFromLocalDatabase();

    }

    private void readAllCoursesFromLocalDatabase() {

        String selectAllSQLQuery = "SELECT * FROM " + CourseContract.COURSE_TABLE_NAME;

        CourseDBHelper classDBHelper = new CourseDBHelper(CourseListActivity.this);
        SQLiteDatabase database = classDBHelper.getReadableDatabase();

        Cursor cursor = database.rawQuery(selectAllSQLQuery, null);
        while (cursor.moveToNext()) {

            long courseId = cursor.getLong(cursor.getColumnIndexOrThrow(CourseContract._ID));

            String courseTitle = cursor.getString(cursor.getColumnIndexOrThrow(CourseContract.COLUMN_COURSE_TITLE));
            String courseDescription = cursor.getString(cursor.getColumnIndexOrThrow(CourseContract.COLUMN_COURSE_DESCRIPTION));

            ModelCourse classModelCourse = new ModelCourse();
            classModelCourse.setCourse_title(courseTitle);
            classModelCourse.setCourse_description(courseDescription);

            listOfSearchedCourses.add(classModelCourse);

        }

        cursor.close();

        if (rvCourseList.getAdapter() != null) {
            rvCourseList.getAdapter().notifyDataSetChanged();
        }

    }

    private void readCoursesFromLocalDatabase() {

        CourseDBHelper classDBHelper = new CourseDBHelper(CourseListActivity.this);
        SQLiteDatabase database = classDBHelper.getReadableDatabase();

        String[] projection = {CourseContract._ID, CourseContract.COLUMN_COURSE_TITLE, CourseContract.COLUMN_COURSE_DESCRIPTION};

        String selection = CourseContract.COLUMN_COURSE_TITLE + " = ?";
        String[] selectionArguments = {"Cybersecurity"};

        Cursor cursor = database.query(CourseContract.COURSE_TABLE_NAME, projection, selection, selectionArguments, null, null, null);

        while (cursor.moveToNext()) {

            long courseId = cursor.getLong(cursor.getColumnIndexOrThrow(CourseContract._ID));

            String courseTitle = cursor.getString(cursor.getColumnIndexOrThrow(CourseContract.COLUMN_COURSE_TITLE));
            String courseDescription = cursor.getString(cursor.getColumnIndexOrThrow(CourseContract.COLUMN_COURSE_DESCRIPTION));

            ModelCourse classModelCourse = new ModelCourse();
            classModelCourse.setCourse_title(courseTitle);
            classModelCourse.setCourse_description(courseDescription);

            listOfSearchedCourses.add(classModelCourse);

        }

        cursor.close();

        if (rvCourseList.getAdapter() != null) {
            rvCourseList.getAdapter().notifyDataSetChanged();
        }

    }

    private void startAddCourseActivity() {

        Intent inStartAddCourse = new Intent(CourseListActivity.this, AddCourseActivity.class);
        this.startActivity(inStartAddCourse);

    }



    private View.OnClickListener clkCourseList = new View.OnClickListener() {

        @Override
        public void onClick(View view) {

            switch (view.getId()) {

                case R.id.fabCourseList:
                    startAddCourseActivity();
                    break;

            }

        }

    };

}
