package uk.co.edwardquixote.Zalego.ZalegoCourseApp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignInActivity extends AppCompatActivity {

    private TextInputLayout tilEmailAddress;
    private TextInputLayout tilPassword;

    private TextInputEditText tiedEmailAddress;
    private TextInputEditText tiedPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        initializeViewsInUI();

    }


    private void initializeViewsInUI() {

        tilEmailAddress = (TextInputLayout) this.findViewById(R.id.tilSignInEmailAddress);
        tilPassword = (TextInputLayout) this.findViewById(R.id.tilSignInPassword);

        tiedEmailAddress = (TextInputEditText) this.findViewById(R.id.tiedSignInEmailAddress);
        tiedPassword = (TextInputEditText) this.findViewById(R.id.tiedSignInPassword);

        TextView txtHaveNoAccount = (TextView) this.findViewById(R.id.txtSignInHaveNoAccount);
        txtHaveNoAccount.setOnClickListener(clkSignIn);

        Button btnSignIn = (Button) this.findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(clkSignIn);

    }

    private void codeToStartSignUpActivity() {

        Intent inStartSignUp = new Intent(SignInActivity.this, SignUpActivity.class);
        this.startActivity(inStartSignUp);
        this.finish();

    }


    private View.OnClickListener clkSignIn = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.txtSignInHaveNoAccount:

                    codeToStartSignUpActivity();

                    break;

                case R.id.btnSignIn:
                    //  TODO: Sign In user here.
                    break;

            }

        }

    };

}
