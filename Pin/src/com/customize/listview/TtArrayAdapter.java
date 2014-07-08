package com.customize.listview;

import java.util.List;

import com.tt.pin.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class TtArrayAdapter extends ArrayAdapter<String> {

	public TtArrayAdapter(Context context,
			int textViewResourceId, List<String> objects) {
		super(context, textViewResourceId, objects);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view;
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(R.layout.tt_list_view, null);
		}else {
			view = convertView;
		}
		TextView tv = (TextView) view.findViewById(R.id.text_view);
		tv.setText(getItem(position));
//		return super.getView(position, convertView, parent);
		return view;
	}

}
