package uk.co.edwardquixote.Zalego.ZalegoCourseApp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.HashMap;
import java.util.Map;

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

    private void codeToStartCourseListActivity() {

        Intent inStartCourseList = new Intent(SignInActivity.this, CourseListActivity.class);
        this.startActivity(inStartCourseList);
        this.finish();

    }

    private boolean codeToValidateUserInput() {

        if (TextUtils.isEmpty(tiedEmailAddress.getText())) {

            tilEmailAddress.setError("Provide Email Address!");

            return false;
        } else if (TextUtils.isEmpty(tiedPassword.getText())) {

            tilPassword.setError("Provide password!");

            return false;
        } else {

            tilEmailAddress.setError(null);
            tilPassword.setError(null);

            return true;
        }
    }

    private void signInUser() {

        final String userEmailAddress = tiedEmailAddress.getText().toString();
        final String userPassword = tiedPassword.getText().toString();

        String signInURL = "http://localhost:80/zalegocourseapp/login.php";

        StringRequest request = new StringRequest(Request.Method.POST, signInURL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                Log.e("SignInActivity", "Sign In response: " + response);

                codeToStartCourseListActivity();

            }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                Log.e("SignInActivity", "Sign In error: " + error);

            }

        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                super.getParams();

                Map<String, String> mapRequestParameters = new HashMap<>();
                mapRequestParameters.put("user_email_address", userEmailAddress);
                mapRequestParameters.put("password", userPassword);

                return mapRequestParameters;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(SignInActivity.this);
        requestQueue.add(request);

    }


    private View.OnClickListener clkSignIn = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.txtSignInHaveNoAccount:

                    codeToStartSignUpActivity();

                    break;

                case R.id.btnSignIn:

                    if (codeToValidateUserInput()) {

                        signInUser();

                    }

                    break;

            }

        }

    };

}
