package com.gmail.huashadow.study.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends BaseActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        findViewById(R.id.btn_start_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDialog();
            }
        });
        findViewById(R.id.btn_start_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMainActivity();
            }
        });
        findViewById(R.id.btn_start_translucent_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTranslucentActivity();
            }
        });
    }

    /**
     * 验证弹出 dialog，会不会触发onPause
     * 结果：不会
     */
    private void startDialog() {
        Dialog dialog = new Dialog(this);
        dialog.show();
    }

    /**
     * 验证启动另一个Activity时，两个Activity的生命周期
     * 结果: ActivitA: onPause -> ActivitB: onCreate -> onStart -> onResume -> ActivityA: onStop
     */
    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    /**
     * 验证启动一个半透明Actvity，会不会触发onStop
     * 结果：不会。onStop只有在Activity完全不可见时才会触发
     */
    private void startTranslucentActivity() {
        Intent intent = new Intent(this, TranslucentActivity.class);
        startActivity(intent);
    }
}