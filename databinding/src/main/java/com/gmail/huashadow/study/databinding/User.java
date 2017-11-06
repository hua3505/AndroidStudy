package com.gmail.huashadow.study.databinding;

/**
 * @author WolfXu on 2017/11/6.
 */

public class User {
    private final String mFirstName;
    private final String mLastName;

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
}
