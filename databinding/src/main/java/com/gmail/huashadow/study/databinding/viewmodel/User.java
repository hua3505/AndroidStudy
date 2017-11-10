package com.gmail.huashadow.study.databinding.viewmodel;

/**
 * @author WolfXu on 2017/11/6.
 */

public class User {
    private String mFirstName;
    private String mLastName;

    public User(String firstName, String lastName) {
        this.mFirstName = firstName;
        this.mLastName = lastName;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }
}
