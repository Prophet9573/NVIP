package com.zhht.fragment;

import java.util.ArrayList;
import java.util.HashMap;

import com.zhht.nvip.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class SecondPager extends Fragment implements OnPageChangeListener {
	private ListView lv_announcement;
	private View view;
	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_main_secondpager, null);
		lv_announcement=(ListView) view.findViewById(R.id.lv_announcement);
		ArrayList<HashMap<String,String>> ah=new ArrayList<HashMap<String,String>>();
		for(int i=0;i<10;i++){
			HashMap<String,String> map= new HashMap<String,String>();
			map.put("announcement_title", "第"+i+"行");
			map.put("announcement_time", i+":"+i);
			ah.add(map);
		}
		SimpleAdapter adapter=new SimpleAdapter(getActivity(), ah, R.layout.annoucement, new String[]{"announcement_title","announcement_time"}, new int[]{R.id.announcement_title,R.id.publish_time});
		lv_announcement.setAdapter(adapter);
		return view;
	}

}
