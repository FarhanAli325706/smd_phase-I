package com.smsaz.fitnessenthusiast.login.presenter;

import com.google.firebase.auth.FirebaseAuth;
import com.smsaz.fitnessenthusiast.login.model.LoginModel;
import com.smsaz.fitnessenthusiast.login.view.ILoginActivity;
import com.smsaz.fitnessenthusiast.login.view.LoginActivity;
import com.smsaz.store_in_shared_preferences_and_cache.SharedPreferencesAndCacheHandler;

public class LoginPresenter implements ILoginPresenter{

    private ILoginActivity loginActivity;
    private LoginModel loginModel;

    public LoginPresenter(ILoginActivity iLoginActivity, LoginModel loginModel){
        this.loginActivity = iLoginActivity;
        this.loginModel = loginModel;
    }

    public void validate(String username, String password){
        this.loginModel.addPresenter(this);
        this.loginModel.authenticate(username,password);
    }

    @Override
    public void validated(boolean result, String message) {
        if(result){
            loginActivity.goToExercises();
        } else {
            loginActivity.showErrorToast(message);
        }
    }
}
