package com.tt.pin.activity;

import java.util.Arrays;
import java.util.LinkedList;

import com.tt.lib.pulltorefresh.PullToRefreshBase;
import com.tt.lib.pulltorefresh.PullToRefreshListView;
import com.tt.lib.pulltorefresh.PullToRefreshBase.OnRefreshListener;
import com.tt.lib.pulltorefresh.fragment.PullToRefreshListFragment;
import com.tt.pin.R;
//import com.tt.pin.activity.PullToRefreshListFragmentActivity.GetDataTask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FragmentPage3 extends Fragment implements OnRefreshListener<ListView>{
	private LinkedList<String> mListItems;
	private ArrayAdapter<String> mAdapter;

	private PullToRefreshListFragment mPullRefreshListFragment;
	private PullToRefreshListView mPullRefreshListView;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

//		setContentView(R.layout.activity_ptr_list_fragment);

        View v = inflater.inflate(R.layout.activity_ptr_list_fragment, container, false);
//        View tv = v.findViewById(R.id.text);
		mPullRefreshListFragment = (PullToRefreshListFragment) getFragmentManager().findFragmentById(R.id.frag_ptr_list);
//		mPullRefreshListFragment = (PullToRefreshListFragment)v.findViewById(R.id.frag_ptr_list);

		// Get PullToRefreshListView from Fragment
		mPullRefreshListView = mPullRefreshListFragment.getPullToRefreshListView();

		// Set a listener to be invoked when the list should be refreshed.
		mPullRefreshListView.setOnRefreshListener(this);

		// You can also just use mPullRefreshListFragment.getListView()
		ListView actualListView = mPullRefreshListView.getRefreshableView();

		mListItems = new LinkedList<String>();
		mListItems.addAll(Arrays.asList(mStrings));
		mAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mListItems);

		// You can also just use setListAdapter(mAdapter) or
		// mPullRefreshListView.setAdapter(mAdapter)
		actualListView.setAdapter(mAdapter);

		mPullRefreshListFragment.setListShown(true);
		// TODO Auto-generated method stub
		return v;
//		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onRefresh(PullToRefreshBase<ListView> refreshView) {

		new GetDataTask().execute();
	}
	private class GetDataTask extends AsyncTask<Void, Void, String[]> {

		@Override
		protected String[] doInBackground(Void... params) {
			// Simulates a background job.
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
			}
			return mStrings;
		}

		@Override
		protected void onPostExecute(String[] result) {
			mListItems.addFirst("Added after refresh...");
			mAdapter.notifyDataSetChanged();

			// Call onRefreshComplete when the list has been refreshed.
			mPullRefreshListView.onRefreshComplete();

			super.onPostExecute(result);
		}
	}
	

	private String[] mStrings = { "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
			"Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
			"Allgauer Emmentaler", "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
			"Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
			"Allgauer Emmentaler" };
}
