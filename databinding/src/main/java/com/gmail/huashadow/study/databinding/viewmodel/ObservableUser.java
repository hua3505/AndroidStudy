package com.gmail.huashadow.study.databinding.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.gmail.huashadow.study.databinding.BR;

/**
 * @author WolfXu on 2017/11/11.
 */

public class ObservableUser extends BaseObservable {
    // @Bindable 加在属性上也是可以的
    private String mFirstName;
    private String mLastName;

    public ObservableUser(String firstName, String lastName) {
        mFirstName = firstName;
        mLastName = lastName;
    }

    // 加@Bindable才会被监听，同时会在BR下生成相应字段。
    @Bindable
    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    @Bindable
    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }
}
