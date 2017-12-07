package com.studybuddy.firebase.model;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by srangan on 12/2/2017.
 */

public class User {

    private String uid;
    private String email;

    public User() {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        this.uid = currentUser.getUid();
        this.email = currentUser.getEmail();
    }

    public String getUid() {
        return uid;
    }

    public User setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }
}
