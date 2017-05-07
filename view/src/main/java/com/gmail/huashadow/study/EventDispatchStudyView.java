package com.gmail.huashadow.study;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by wolf on 2017/4/20.
 * 研究事件分发机制
 */

public class EventDispatchStudyView extends View {

    public static final String TAG = EventDispatchStudyView.class.getSimpleName();

    private Point mFirstPoint = null;
    private Point mSecondPoint = null;
    private Paint mPaint;

    public EventDispatchStudyView(Context context)
    {
        super(context);
        init();
    }

    public EventDispatchStudyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EventDispatchStudyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStrokeWidth(20);
        mPaint.setColor(Color.GREEN);
        mPaint.setTextSize(60);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mFirstPoint != null && mSecondPoint != null) {
            canvas.drawLine(mFirstPoint.x, mFirstPoint.y, mSecondPoint.x, mSecondPoint.y, mPaint);
            canvas.drawText("" + distance(mFirstPoint, mSecondPoint), 100, 100, mPaint);
        }
    }

    private int distance(Point pointA, Point pointB) {
        if (pointA == null || pointB == null) {
            return -1;
        }
        return (int) Math.sqrt(Math.pow((pointA.x - pointB.x), 2) + Math.pow((pointA.y - pointB.y), 2));
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.d(TAG, "dispatchTouchEvent " + event.getActionMasked());
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean needInvalidate = true;
        switch (event.getActionMasked()) {
        case MotionEvent.ACTION_DOWN:
            mFirstPoint = new Point((int) event.getX(), (int) event.getY());
            break;
        case MotionEvent.ACTION_POINTER_DOWN:
            if (event.getActionIndex() == 1) {
                mSecondPoint = new Point((int) event.getX(event.getActionIndex()),
                        (int) event.getY(event.getActionIndex()));
            }
            break;
        case MotionEvent.ACTION_POINTER_UP:
            if (event.getActionIndex() == 1) {
                mSecondPoint = null;
            }
            break;
        case MotionEvent.ACTION_UP:
            mFirstPoint = null;
            break;
        case MotionEvent.ACTION_CANCEL:
            mFirstPoint = null;
            mSecondPoint = null;
            break;
        case MotionEvent.ACTION_MOVE:
            if (mFirstPoint != null && event.getPointerCount() >= 1) {
                mFirstPoint.set((int) event.getX(), (int) event.getY());
            }
            if (mSecondPoint != null && event.getPointerCount() >= 2) {
                mSecondPoint.set((int) event.getX(1), (int) event.getY(1));
            }
            break;
        default:
            needInvalidate = false;
            break;
        }
        if (needInvalidate) {
            invalidate();
        }
        return true;
    }
}
