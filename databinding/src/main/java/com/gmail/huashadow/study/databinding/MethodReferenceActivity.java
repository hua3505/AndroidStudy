package com.gmail.huashadow.study.databinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.gmail.huashadow.study.databinding.databinding.ActivityMethodReferenceBinding;

public class MethodReferenceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMethodReferenceBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_method_reference);
        binding.setHandler(new MyHandlers());
    }
}
