package com.gmail.huashadow.study.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by wolf on 2017/4/22.
 * BaseActivity
 */

public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        log("onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        log("onStart");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        log("onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        log("onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        log("onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        log("onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        log("onDestory");
        super.onDestroy();
    }

    private void log(String log) {
        Log.d(getClass().getSimpleName(), log);
    }
}
