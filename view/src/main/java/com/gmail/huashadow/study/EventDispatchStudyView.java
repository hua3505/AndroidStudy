package com.gmail.huashadow.study;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by wolf on 2017/4/20.
 * 研究事件分发机制
 */

public class EventDispatchStudyView extends View {
    public EventDispatchStudyView(Context context) {
        super(context);
    }

    public EventDispatchStudyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EventDispatchStudyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
