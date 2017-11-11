package com.gmail.huashadow.study.databinding.viewmodel;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;

import com.android.databinding.library.baseAdapters.BR;

/**
 * @author WolfXu on 2017/11/11.
 */

public class ObservableUser2 implements Observable {

    private PropertyChangeRegistry mPropertyChangeRegistry = new PropertyChangeRegistry();

    private String mFirstName;
    private String mLastName;

    public ObservableUser2(String firstName, String lastName) {
        mFirstName = firstName;
        mLastName = lastName;
    }

    @Bindable
    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
        mPropertyChangeRegistry.notifyChange(this, BR.firstName);
    }

    @Bindable
    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
        mPropertyChangeRegistry.notifyChange(this, BR.lastName);
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        mPropertyChangeRegistry.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        mPropertyChangeRegistry.remove(callback);
    }
}
