//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations 3.0.1.
//


package com.tt.pin.task;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import org.androidannotations.api.BackgroundExecutor;

public final class TestBgTask_
    extends TestBgTask
{

    private Context context_;
    private Handler handler_ = new Handler(Looper.getMainLooper());

    private TestBgTask_(Context context) {
        context_ = context;
        init_();
    }

    public static TestBgTask_ getInstance_(Context context) {
        return new TestBgTask_(context);
    }

    private void init_() {
        ctx = context_;
    }

    public void rebind(Context context) {
        context_ = context;
        init_();
    }

    @Override
    public void updateMainUi() {
        handler_.post(new Runnable() {


            @Override
            public void run() {
                TestBgTask_.super.updateMainUi();
            }

        }
        );
    }

    @Override
    public void dosomethingInBack() {
        BackgroundExecutor.execute(new BackgroundExecutor.Task("", 0, "") {


            @Override
            public void execute() {
                try {
                    TestBgTask_.super.dosomethingInBack();
                } catch (Throwable e) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
                }
            }

        }
        );
    }

}