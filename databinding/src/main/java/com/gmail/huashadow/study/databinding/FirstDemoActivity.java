package com.gmail.huashadow.study.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gmail.huashadow.study.databinding.databinding.ActivityFirstDemoBinding;

public class FirstDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFirstDemoBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_first_demo);
        User user = new User("Test", "User");
        binding.setUser(user);
    }
}
