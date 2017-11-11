package com.gmail.huashadow.study.databinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gmail.huashadow.study.databinding.databinding.ActivityCollectionsBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WolfXu on 2017/11/11.
 */

public class CollectionsActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollectionsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_collections);
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        binding.setList(list);
        Map<String, String> map = new HashMap<>();
        map.put("dd", "ok");
        binding.setMap(map);
    }
}
