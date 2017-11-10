package com.gmail.huashadow.study.databinding;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.gmail.huashadow.study.databinding.databinding.ActivityMethodReferenceBinding;

public class MethodReferenceActivity extends Activity {

    private ActivityMethodReferenceBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_method_reference);
        mBinding.setHandler(new MyHandlers());
        mBinding.setCount(0);
    }


    public class MyHandlers {
        public void onClickFriend(View view) {
            int count = mBinding.getCount();
            mBinding.setCount(++count);
        }
    }
}
