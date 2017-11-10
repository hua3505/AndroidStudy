package com.gmail.huashadow.study.databinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.gmail.huashadow.study.databinding.databinding.ActivityIncludeBinding;
import com.gmail.huashadow.study.databinding.viewmodel.User;

public class IncludeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityIncludeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_include);
        binding.setUser(new User("First", "Last"));
    }
}
