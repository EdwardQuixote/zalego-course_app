package uk.co.edwardquixote.Zalego.ZalegoCourseApp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import uk.co.edwardquixote.Zalego.ZalegoCourseApp.Database.CourseContract;
import uk.co.edwardquixote.Zalego.ZalegoCourseApp.Database.CourseDBHelper;

public class AddCourseActivity extends AppCompatActivity {

    private TextInputLayout tilCourseTitle;
    private TextInputLayout tilCourseDescription;


    private TextInputEditText tiedCourseTitle;
    private TextInputEditText tiedCourseDescription;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        initializeViewsOnUI();

    }


    private void initializeViewsOnUI() {

        tilCourseTitle = (TextInputLayout) this.findViewById(R.id.tilAddCourseTitle);
        tilCourseDescription = (TextInputLayout) this.findViewById(R.id.tilAddCourseDescription);

        tiedCourseTitle = (TextInputEditText) this.findViewById(R.id.tiedAddCourseTitle);
        tiedCourseDescription = (TextInputEditText) this.findViewById(R.id.tiedAddCourseDescription);

        Button btnSaveCourse = (Button) this.findViewById(R.id.btnSaveCourse);
        btnSaveCourse.setOnClickListener(clkAddCourse);

    }

    private void codeToSaveCourseToDatabase() {

        String courseTitle = tiedCourseTitle.getText().toString();
        String courseDescription = tiedCourseDescription.getText().toString();

        CourseDBHelper classDBHelper = new CourseDBHelper(AddCourseActivity.this);
        SQLiteDatabase database = classDBHelper.getWritableDatabase();

        ContentValues classContentValues = new ContentValues();
        classContentValues.put(CourseContract.COLUMN_COURSE_TITLE, courseTitle);
        classContentValues.put(CourseContract.COLUMN_COURSE_DESCRIPTION, courseDescription);

        long idOfNewlySavedRow = database.insert(CourseContract.COURSE_TABLE_NAME, null, classContentValues);

        Log.e("AddCourseActivity", "codeToSaveCourseToDatabase() - idOfNewlySavedRow: " + idOfNewlySavedRow);

    }

    private boolean codeToValidateUserInput() {

        if (TextUtils.isEmpty(tiedCourseTitle.getText())) {

            tilCourseTitle.setError("Provide course title!");

            return false;
        } else if (TextUtils.isEmpty(tiedCourseDescription.getText())) {

            tilCourseDescription.setError("Provide coourse description!");

            return false;
        } else {

            tilCourseTitle.setError(null);
            tilCourseDescription.setError(null);

            return true;
        }

    }


    private View.OnClickListener clkAddCourse = new View.OnClickListener() {

        @Override
        public void onClick(View view) {

            switch (view.getId()) {

                case R.id.btnSaveCourse:

                    if (codeToValidateUserInput()) {
                        codeToSaveCourseToDatabase();
                    }

                    break;

            }

        }

    };

}
