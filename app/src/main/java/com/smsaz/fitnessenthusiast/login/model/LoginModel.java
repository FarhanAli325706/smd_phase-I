package com.smsaz.fitnessenthusiast.login.model;

import com.smsaz.fitnessenthusiast.login.presenter.ILoginPresenter;

public class LoginModel {

    private ILoginPresenter loginPresenter;

    public void addPresenter(ILoginPresenter iLoginPresenter) {
        this.loginPresenter = iLoginPresenter;
    }

    public void authenticate(String username, String password) {

        //TODO: Get data from database and check.

        if (username.equals("sajjad@gmail.com") && password.equals("hello"))
            this.loginPresenter.validated(true);
        else
            this.loginPresenter.validated(false);
    }

}
