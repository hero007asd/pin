package com.tt.pin.view;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import com.tt.pin.R;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

@EViewGroup(R.layout.merge_title_with_subtitle)
public class TitleWithSubtitle extends RelativeLayout{

	@ViewById
	TextView title, subtitle;
	
	public TitleWithSubtitle(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public void setTexts(String titleText, String subtitleText){
		title.setText(titleText);
		subtitle.setText(subtitleText);
	}
}
