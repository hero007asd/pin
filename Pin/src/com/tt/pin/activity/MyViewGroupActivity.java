package com.tt.pin.activity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import com.tt.pin.R;
import com.tt.pin.view.TitleWithSubtitle;

import android.app.Activity;
import android.os.Bundle;

@EActivity(R.layout.activity_viewgroup)
public class MyViewGroupActivity extends Activity {
	
	@ViewById
	TitleWithSubtitle firstTitle, secondTitle, thirdTitle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@AfterViews
	void init(){
		firstTitle.setTexts("decouple your code",
				"Hide the component logic from the code using it.");
		
        secondTitle.setTexts("write once, reuse anywhere",
                "Declare you component in multiple " +
                "places, just as easily as you " +
                "would put a single basic View.");

        thirdTitle.setTexts("Let's get stated!",
                "Let's see how AndroidAnnotations can make it easier!");
	}
}
