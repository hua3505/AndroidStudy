package com.gmail.huashadow.study.databinding;

import android.view.View;
import android.widget.Button;

/**
 * @author WolfXu on 2017/11/7.
 */

public class MyHandlers {
    private int mCount = 0;
    public void onClickFriend(View view) {
        String text = ++mCount + "";
        ((Button) view).setText(text);
    }
}
