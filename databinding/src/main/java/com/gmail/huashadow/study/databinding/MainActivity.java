package com.gmail.huashadow.study.databinding;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.gmail.huashadow.study.databinding.databinding.ItemActivityStartButtonBinding;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {

    private final Map<String, Class> mButtonInfos = new HashMap<String, Class>() {
        {
            put("First Demo Activity", FirstDemoActivity.class);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButtons();
    }

    private void initButtons() {
        ViewGroup container = findViewById(R.id.ll_container);
        for (String buttonText : mButtonInfos.keySet()) {
//            ItemActivityStartButtonBinding buttonBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.item_activity_start_button, container, true);
            ItemActivityStartButtonBinding buttonBinding = ItemActivityStartButtonBinding.inflate(getLayoutInflater(), container, true);
            buttonBinding.setText(buttonText);
        }
    }
}
