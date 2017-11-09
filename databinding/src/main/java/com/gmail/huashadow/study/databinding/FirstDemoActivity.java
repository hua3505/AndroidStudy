package com.gmail.huashadow.study.databinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.gmail.huashadow.study.databinding.databinding.ActivityFirstDemoBinding;
import com.gmail.huashadow.study.databinding.viewmodel.User;

public class FirstDemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFirstDemoBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_first_demo);
        User user = new User("Test", "User");
        binding.setUser(user);
    }
}
