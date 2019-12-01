package com.smsaz.googlesignin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class GoogleSignInActivity extends AppCompatActivity {

    Context context;
    boolean toReturn = false;

    //EXTRA CODE FOR GOOGLE SIGN-IN STARTED
    private GoogleSignInClient googleSignInClient;
    private final String TAG = "Login Activity";
    private int RC_SIGN_IN = 1;
    private FirebaseAuth firebaseAuth;
    //EXTRA CODE FOR GOOGLE SIGN-IN ENDED


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void receiveParameters(Context context) {
        firebaseAuth = FirebaseAuth.getInstance();
        this.context = context;
    }

    public boolean initiateSignInWithGoogle(String default_web_client_id){

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).
                requestIdToken(default_web_client_id).
                requestEmail().build();

        googleSignInClient = com.google.android.gms.auth.api.signin.GoogleSignIn.getClient(context,gso);

        signInWithGoogle();

        return toReturn;
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

                            Toast.makeText(context, "Welcome through GOOGLE SIGN-IN", Toast.LENGTH_SHORT).show();
                            toReturn = true;
//                            startActivity(new Intent(context, HomeActivity.class));

                            //TODO: Do what we want to do with the signed in user
                            //TODO: If this is sign-in, show the UI of this user.
                            //TODO: If this is sign-up, store credentials of this user in firebase database.

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            toReturn = false;
//                            Snackbar.make(findViewById(R.id.activity_login), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
//                            updateUI(null);
                        }

                        // ...
                    }
                });
    }
    //EXTRA CODE FOR GOOGLE SIGN-IN ENDED-----------------------------------------------------------------
}
