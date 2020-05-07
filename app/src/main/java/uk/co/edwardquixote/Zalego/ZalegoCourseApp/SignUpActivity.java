package uk.co.edwardquixote.Zalego.ZalegoCourseApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity {

    private TextInputLayout tilEmailAddress;
    private TextInputLayout tilPassword;
    private TextInputLayout tilConfirmPassword;

    private TextInputEditText tiedEmailAddress;
    private TextInputEditText tiedPassword;
    private TextInputEditText tiedConfirmPassword;

    private EditText edFirstName;
    private EditText edMiddleName;
    private EditText edSurname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        initializeViewsInUI();

    }


    private void initializeViewsInUI() {

        tilEmailAddress = (TextInputLayout) this.findViewById(R.id.tilSignUpEmailAddress);
        tilPassword = (TextInputLayout) this.findViewById(R.id.tilSignUpPassword);
        tilConfirmPassword = (TextInputLayout) this.findViewById(R.id.tilSignUpConfirmPassword);

        tiedEmailAddress = (TextInputEditText) this.findViewById(R.id.tiedSignUpEmailAddress);
        tiedPassword = (TextInputEditText) this.findViewById(R.id.tiedSignUpPassword);
        tiedConfirmPassword = (TextInputEditText) this.findViewById(R.id.tiedSignUpConfirmPassword);

        edFirstName = (EditText) this.findViewById(R.id.edSignUpFirstName);
        edMiddleName = (EditText) this.findViewById(R.id.edSignUpMiddleName);
        edSurname = (EditText) this.findViewById(R.id.edSignUpSurname);

        TextView txtHaveAnAccount = (TextView) this.findViewById(R.id.txtSignUpHaveAnAccount);
        txtHaveAnAccount.setOnClickListener(clkSignUp);

        Button btnSignUp = (Button) this.findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(clkSignUp);

    }

    private void codeToStartSignInActivity() {

        Intent inStartSignIn = new Intent(SignUpActivity.this, SignInActivity.class);
        this.startActivity(inStartSignIn);
        this.finish();

    }

    private void codeToStartCourseListActivity() {

        Intent inStartCourseList = new Intent(SignUpActivity.this, CourseListActivity.class);
        this.startActivity(inStartCourseList);
        this.finish();

    }


    private View.OnClickListener clkSignUp = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.txtSignUpHaveAnAccount:

                    codeToStartSignInActivity();

                    break;

                case R.id.btnSignUp:
                    //  TODO: Sign Up user here.

                    codeToStartCourseListActivity();

                    break;

            }

        }

    };

}
