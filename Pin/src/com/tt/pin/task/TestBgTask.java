package com.tt.pin.task;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;

import android.content.Context;

import com.tt.pin.MainActivity;

@EBean
public class TestBgTask {
	@RootContext
	Context ctx;
	
	@Background
	public void dosomethingInBack(){
		updateMainUi();
	}
	
	@UiThread
	void updateMainUi(){
		((MainActivity)ctx).tv1.setText("haha!i'm TestBgTask");
	}

}
