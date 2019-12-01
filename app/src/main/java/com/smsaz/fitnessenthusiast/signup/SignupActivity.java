package com.smsaz.fitnessenthusiast.signup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.smsaz.fitnessenthusiast.ExercieList;
import com.smsaz.fitnessenthusiast.login.view.LoginActivity;
import com.smsaz.fitnessenthusiast.R;

public class SignupActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;

    //TODO: Implement Back Button in Signup Activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firebaseAuth = FirebaseAuth.getInstance();

    }

    public void toLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);

        EditText usernameView = findViewById(R.id.usernameSignup);
        EditText emailView = findViewById(R.id.emailSignup);
        EditText passwordView = findViewById(R.id.passwordSignup);
        EditText confirmPasswordView = findViewById(R.id.confirmPasswordSignup);

        String username = usernameView.getText().toString();
        String email = emailView.getText().toString();
        String password = passwordView.getText().toString();
        String confirmPassword = confirmPasswordView.getText().toString();

        if (username.matches("") || email.matches("") ||
                password.matches("") || confirmPassword.matches("")) {
            Toast.makeText(this, "All fields must be filled!", Toast.LENGTH_SHORT).show();
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Enter a valid Email", Toast.LENGTH_SHORT).show();
        } else if (!password.matches(confirmPassword)) {
            Toast.makeText(this, "Password Mismatch", Toast.LENGTH_SHORT).show();
        } else {
            firebaseAuth.createUserWithEmailAndPassword(email, password).
                    addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                        .setDisplayName(username).build();

                                user.updateProfile(profileUpdates)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Toast.makeText(SignupActivity.this, "Welcome to Fitness Enthusiast " + user.getDisplayName(), Toast.LENGTH_SHORT).show();
                                                    startActivity(new Intent(SignupActivity.this, ExercieList.class));
                                                }
                                            }
                                        });

                            } else {
                                if (task.getException() != null)
                                    Toast.makeText(SignupActivity.this, "Error While Signing Up\n" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

}
