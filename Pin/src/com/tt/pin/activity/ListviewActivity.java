package com.tt.pin.activity;

import java.util.ArrayList;
import java.util.List;

import com.customize.listview.IttListView;
import com.customize.listview.TtListView;
import com.customize.listview.TtListViewFactory;
import com.tt.pin.R;

import android.app.Activity;
import android.os.Bundle;

public class ListviewActivity extends Activity {
	private TtListView ttListView;
	private List<String> contentList = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_test);
		initList();
		ttListView = (TtListView) findViewById(R.id.my_list_view);
		IttListView itt = TtListViewFactory.create();
		itt.showSimpleTextList(this, ttListView, contentList);
	}
	
	private void initList() {  
        contentList.add("Content Item 1");  
        contentList.add("Content Item 2");  
        contentList.add("Content Item 3");  
        contentList.add("Content Item 4");  
        contentList.add("Content Item 5");  
        contentList.add("Content Item 6");  
        contentList.add("Content Item 7");  
        contentList.add("Content Item 8");  
        contentList.add("Content Item 9");  
        contentList.add("Content Item 10");  
        contentList.add("Content Item 11");  
        contentList.add("Content Item 12");  
        contentList.add("Content Item 13");  
        contentList.add("Content Item 14");  
        contentList.add("Content Item 15");  
        contentList.add("Content Item 16");  
        contentList.add("Content Item 17");  
        contentList.add("Content Item 18");  
        contentList.add("Content Item 19");  
        contentList.add("Content Item 20"); 
    }
}
