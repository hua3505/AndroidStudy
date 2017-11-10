package com.gmail.huashadow.study.databinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gmail.huashadow.study.databinding.databinding.ActivityFirstDemoBinding;
import com.gmail.huashadow.study.databinding.databinding.ActivityListeningBindingBinding;

public class ListeningBindingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityListeningBindingBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_listening_binding);
        binding.setPresenter(new Presenter());
    }

    public class Presenter {
        public void onCompletedChanged(boolean completed) {

        }

        public boolean onLongClick() {
            return true;
        }
    }
}
