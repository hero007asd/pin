package com.customize.listview;

import com.tt.pin.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class TtListView extends ListView implements OnTouchListener,OnGestureListener{
	
	private GestureDetector gestureDetector;
	private OnDeleteListener listener;
	private View deleteButton;
	private ViewGroup itemLayout;
	private int selectedItem;
	private boolean isDeleteShown;

	public TtListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		gestureDetector = new GestureDetector(getContext(), this);
		setOnTouchListener(this);
	}
	
	protected void setOnDeleteListener(OnDeleteListener l){
		listener = l;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if(isDeleteShown){
			itemLayout.removeView(deleteButton);
			deleteButton = null;
			isDeleteShown = false;
			return false;
		} else {
			return gestureDetector.onTouchEvent(event);
		}
	}

	@Override
	public boolean onDown(MotionEvent e) {
		if(!isDeleteShown) {
			selectedItem = pointToPosition((int)e.getX(), (int)e.getY());
		}
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		if (!isDeleteShown && Math.abs(velocityX) > Math.abs(velocityY)){
			deleteButton = LayoutInflater.from(getContext()).inflate(R.layout.tt_delete_button, null);
			deleteButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					itemLayout.removeView(deleteButton);
					deleteButton = null;
					isDeleteShown = false;
					listener.onDelete(selectedItem);
				}
			});
			itemLayout = (ViewGroup) getChildAt(selectedItem - getFirstVisiblePosition());
			RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
			params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
			params.addRule(RelativeLayout.CENTER_VERTICAL);
			itemLayout.addView(deleteButton, params);
			isDeleteShown = true;
		}
		return false;
	}

	@Override
	public void onLongPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	public interface OnDeleteListener {  
        void onDelete(int index);  
    }  
}
