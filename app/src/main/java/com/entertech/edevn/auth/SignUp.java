package com.entertech.edevn.auth;

import retrofit2.Call;

public class SignUp {

    private String email;

    public SignUp(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}
