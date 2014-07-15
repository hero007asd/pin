package com.tt.pin.activity;

import com.tt.pin.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class FragmentPage2 extends Fragment {
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {  
    	Toast.makeText(getActivity(), "fragment2", Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_2, null);       
    }  
}
