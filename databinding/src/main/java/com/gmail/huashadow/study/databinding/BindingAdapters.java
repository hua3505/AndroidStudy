package com.gmail.huashadow.study.databinding;

import android.databinding.BindingAdapter;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.view.View;
import android.widget.ImageView;

/**
 * @author WolfXu on 2017/11/11.
 */

// 官方文档写错了，type接收的是Class，而不是字符串
@BindingMethods({
        @BindingMethod(type = ImageView.class,
                attribute = "android:tint",
                method = "setImageTintList"),
})
public class BindingAdapters {
//    @BindingAdapter("android:haha")
//    public static void setHaha(View view, int padding) {
//        view.setPadding(padding,
//                view.getPaddingTop(),
//                view.getPaddingRight(),
//                view.getPaddingBottom());
//    }

    @BindingAdapter("android:haha")
    public static void setHaha(View view, int oldPadding, int newPadding) {
        view.setPadding(newPadding,
                view.getPaddingTop(),
                view.getPaddingRight(),
                view.getPaddingBottom());
    }
}
