package com.gmail.huashadow.study.databinding.viewmodel;

import android.databinding.ObservableField;

/**
 * @author WolfXu on 2017/11/11.
 */

public class ObservableFieldsUser {
    // 必须是public
    public ObservableField<String> firstName;
    public ObservableField<String> lastName;

    public ObservableFieldsUser(String _firstName, String _lastName) {
        firstName = new ObservableField<>(_firstName);
        lastName = new ObservableField<>(_lastName);
    }


}
