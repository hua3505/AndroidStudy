package com.gmail.huashadow.study.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gmail.huashadow.study.databinding.databinding.ActivityImportsBinding;
import com.gmail.huashadow.study.databinding.viewmodel.User;

public class ImportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityImportsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_imports);
        binding.setUser(new User("Stephen", "Curry", false));
    }
}
