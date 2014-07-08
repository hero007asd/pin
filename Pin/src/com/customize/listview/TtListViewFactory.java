package com.customize.listview;

import java.util.List;
import android.content.Context;
import com.customize.listview.TtListView.OnDeleteListener;

public class TtListViewFactory implements IttListView{

	private TtListView ttListView;
	private TtArrayAdapter myAdapter;
	
	private TtListViewFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static TtListViewFactory create(){
		TtListViewFactory tt = new TtListViewFactory();
		return tt;
	}
	
	@Override
	public void showSimpleTextList(Context ctx, TtListView view, final List<String> contentList){
		ttListView = view;
		ttListView.setOnDeleteListener(new OnDeleteListener() {
			@Override
			public void onDelete(int index) {
				contentList.remove(index);
				myAdapter.notifyDataSetChanged();
			}
		});
		myAdapter = new TtArrayAdapter(ctx, 0, contentList);
		ttListView.setAdapter(myAdapter);
	}
	
	@Override
	public void showImgTxtImgList(Context ctx, TtListView view){
		
	}
	
	
}
