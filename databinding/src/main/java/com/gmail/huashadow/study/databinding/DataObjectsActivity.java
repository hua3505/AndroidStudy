package com.gmail.huashadow.study.databinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.gmail.huashadow.study.databinding.databinding.ActivityDataObjectsBinding;
import com.gmail.huashadow.study.databinding.viewmodel.ObservableUser;
import com.gmail.huashadow.study.databinding.viewmodel.ObservableUser2;

public class DataObjectsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityDataObjectsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_data_objects);
        binding.setObservableUser(new ObservableUser("Stephen", "Curry"));
        binding.setObservableUser2(new ObservableUser2("Klay", "Thompson"));
        binding.getRoot().postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.getObservableUser().setFirstName("MVP");
                binding.getObservableUser2().setFirstName("Buddha");
            }
        }, 2000);
    }
}
