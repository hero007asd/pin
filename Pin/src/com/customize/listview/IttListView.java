package com.customize.listview;

import java.util.List;

import android.content.Context;

public interface IttListView {
	/**
	 * 显示简单的单行文本listview
	 * @param ctx
	 * @param view
	 * @param contentList
	 */
	public void showSimpleTextList(Context ctx, TtListView view, final List<String> contentList);
	
	/**
	 * 显示左边图片，中间上下文本，右边图片的listview
	 * @param ctx
	 * @param view
	 */
	public void showImgTxtImgList(Context ctx, TtListView view);
}
