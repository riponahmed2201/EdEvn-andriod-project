package com.entertech.edevn.Model.PojoClass;

import retrofit2.Call;

public class SignUpModel {

    private String email;

    public SignUpModel(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}
