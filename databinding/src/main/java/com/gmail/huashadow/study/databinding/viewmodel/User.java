package com.gmail.huashadow.study.databinding.viewmodel;

/**
 * @author WolfXu on 2017/11/6.
 */

public class User {
    private String mFirstName;
    private String mLastName;

    private boolean mIsAdult;

    public User(String firstName, String lastName) {
        this.mFirstName = firstName;
        this.mLastName = lastName;
    }

    public User(String firstName, String lastName, boolean isAdult) {
        this(firstName, lastName);
        mIsAdult = isAdult;
    }

    public String getFirstName() {
        return mFirstName;
    }

    // user.firstName，优先找getFirstName()，然后是firstName()，然后是firstName成员变量
    public String firstName() {
        return "firstName()";
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

    public boolean isAdult() {
        return mIsAdult;
    }

    public void setAdult(boolean adult) {
        mIsAdult = adult;
    }
}
