package com.smsaz.fitnessenthusiast.signup;

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

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
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
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.smsaz.fitnessenthusiast.ExercieList;
import com.smsaz.fitnessenthusiast.login.view.LoginActivity;
import com.smsaz.fitnessenthusiast.R;

import java.util.Arrays;

public class SignupActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    private LoginButton facebookSignInButton;
    private CallbackManager callbackManager;

    //EXTRA CODE FOR GOOGLE SIGN-IN STARTED
    private Button signInButton;
    private GoogleSignInClient googleSignInClient;
    private final String TAG = "Login Activity";
    private int RC_SIGN_IN = 1;
    //EXTRA CODE FOR GOOGLE SIGN-IN ENDED

    //TODO: Implement Back Button in Signup Activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        firebaseAuth = FirebaseAuth.getInstance();

        //EXTRA CODE FOR GOOGLE SIGN-IN STARTED----------------

        signInButton = findViewById(R.id.gmail_btn);
        facebookSignInButton = findViewById(R.id.facebook_btn);

        callbackManager = CallbackManager.Factory.create();

        facebookSignInButton.setReadPermissions(Arrays.asList("email"));

        facebookSignInButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                handleFacebookAccessToken(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "facebook:onCancel");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "facebook:onError: " + error.getMessage());
            }
        });


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).
                requestIdToken(getString(R.string.default_web_client_id)).
                requestEmail().build();

        googleSignInClient = GoogleSignIn.getClient(this, gso);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInWithGoogle();
            }
        });

        //EXTRA CODE FOR GOOGLE SIGN-IN ENDED----------------

        Button redirectToLoginButton = findViewById(R.id.login_button);
        redirectToLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
        });

    }

    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            Toast.makeText(SignupActivity.this, "Welcome through FACEBOOK SIGN-IN", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignupActivity.this, ExercieList.class));
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(SignupActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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


    //EXTRA CODE FOR GOOGLE SIGN-IN STARTED-----------------------------------------------------------------
    void signInWithGoogle() {
        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
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

                            Toast.makeText(SignupActivity.this, "Welcome through GOOGLE SIGN-IN", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignupActivity.this, ExercieList.class));

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

    //EXTRA CODE FOR GOOGLE SIGN-IN ENDED-----------------------------------------------------------------

}
