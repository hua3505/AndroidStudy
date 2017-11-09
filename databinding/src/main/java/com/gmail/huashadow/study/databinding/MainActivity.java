package com.gmail.huashadow.study.databinding;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;

import com.gmail.huashadow.study.databinding.databinding.ItemActivityStartButtonBinding;

import java.util.LinkedHashMap;
import java.util.Map;

public class MainActivity extends Activity {

    private ButtonHandler mHandler = new ButtonHandler();

    private final Map<String, Class> mButtonInfos = new LinkedHashMap<String, Class>() {
        {
            put("First Demo Activity", FirstDemoActivity.class);
            put("Method Reference Activity", MethodReferenceActivity.class);
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
            buttonBinding.setHandlers(mHandler);
        }
    }

    public class ButtonHandler {
        public void onClick(String text) {
            Class clazz = mButtonInfos.get(text);
            if (clazz != null) {
                startActivity(new Intent(MainActivity.this, clazz));
            }
        }
    }
}
