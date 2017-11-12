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
        final ActivityFirstDemoBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_first_demo);
        User user = new User("Test", "User");
        binding.setUser(user);


        binding.getRoot().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 界面不会改变
                binding.getUser().setFirstName("Hello");
            }
        }, 1000);
        binding.getRoot().postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.setUser(new User("Test", "World"));
            }
        }, 3000);
    }
}
