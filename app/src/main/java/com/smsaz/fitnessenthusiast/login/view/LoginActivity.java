package com.smsaz.fitnessenthusiast.login.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.smsaz.fitnessenthusiast.ExercieList;
import com.smsaz.fitnessenthusiast.R;
import com.smsaz.fitnessenthusiast.login.model.LoginModel;
import com.smsaz.fitnessenthusiast.login.presenter.LoginPresenter;
import com.smsaz.fitnessenthusiast.signup.SignupActivity;
import com.smsaz.googlesignin.GoogleSignInActivity;

public class LoginActivity extends AppCompatActivity implements ILoginActivity {

    //TODO: Implement Back Button in Login Activity

    private Intent exerciesIntent;
    private LoginPresenter loginPresenter;
    private LoginModel loginModel;
    private Button googleSignInButton;
    private boolean googleSignInReturnedValue;

    //EXTRA CODE FOR GOOGLE SIGN-IN STARTED
    private GoogleSignInClient googleSignInClient;
    private final String TAG = "Login Activity";
    private int RC_SIGN_IN = 1;
    private FirebaseAuth firebaseAuth;
    //EXTRA CODE FOR GOOGLE SIGN-IN ENDED

    EditText emailView, passwordView;

    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        exerciesIntent = new Intent(this, ExercieList.class);

        emailView = findViewById(R.id.edit_email);
        passwordView = findViewById(R.id.edit_password);

        googleSignInButton = findViewById(R.id.gmail_btn);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).
                requestIdToken(getString(R.string.default_web_client_id)).
                requestEmail().build();

        googleSignInClient = com.google.android.gms.auth.api.signin.GoogleSignIn.getClient(LoginActivity.this,gso);

        googleSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInWithGoogle();
             }
        });

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser != null) {
                    Toast.makeText(LoginActivity.this, "You are already logged in", Toast.LENGTH_SHORT).show();
                    startActivity(exerciesIntent);
                } else {
                    Toast.makeText(LoginActivity.this, "Please Login to Continue", Toast.LENGTH_SHORT).show();
                }
            }
        };

    }

    public void toExercises(View view) {
        String email = emailView.getText().toString();
        String password = passwordView.getText().toString();

        if (email.matches("") || password.matches("")) {
            Toast.makeText(this, "All fields must be filled!", Toast.LENGTH_SHORT).show();
        } else if (!(Patterns.EMAIL_ADDRESS.matcher(email).matches())) {
            Toast.makeText(this, "Enter a valid email.", Toast.LENGTH_SHORT).show();
        } else {
            //Calling Presenter's methods
            loginModel = new LoginModel();
            loginPresenter = new LoginPresenter(this, loginModel);
            loginPresenter.validate(email, password);
        }

    }

    public void toSignup(View view) {
        Intent intent = new Intent(this, SignupActivity.class);
        startActivity(intent);
    }

    @Override
    public void goToExercises() {
        Toast.makeText(this, "Welcome to Fitness Enthusiast", Toast.LENGTH_SHORT).show();
        startActivity(exerciesIntent);
        //Put current user in cache
    }

    @Override
    public void showErrorToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    //EXTRA CODE FOR GOOGLE SIGN-IN STARTED-----------------------------------------------------------------
    void signInWithGoogle(){
        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent,RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = com.google.android.gms.auth.api.signin.
                    GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.v(TAG, "Google sign in failed:" + e.getMessage());
                // ...
            }
        }
    }

    //TODO: Overriding onStart to check if user is already signed in or not

    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();

                            Toast.makeText(LoginActivity.this, "Welcome through GOOGLE SIGN-IN", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, ExercieList.class));
//                            Toast.makeText(LoginActivity.this, "Login With Gmail Failed", Toast.LENGTH_SHORT).show();

//                            startActivity(new Intent(context, HomeActivity.class));

                            //TODO: Do what we want to do with the signed in user
                            //TODO: If this is sign-in, show the UI of this user.
                            //TODO: If this is sign-up, store credentials of this user in firebase database.

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Snackbar.make(findViewById(R.id.activity_login), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
//                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

}
