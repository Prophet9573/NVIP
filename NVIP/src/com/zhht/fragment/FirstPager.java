package com.zhht.fragment;

import com.zhht.nvip.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class FirstPager extends Fragment implements OnPageChangeListener {
	private ImageView iv_iscomputer;
	private LinearLayout ll_iscomputer;
	private ImageView iv_isvibrator;
	private LinearLayout ll_isvibrator;
	private ImageView iv_ismoney;
	private LinearLayout ll_ismoney;
	private boolean iv_iscomputer_isfront=false;
	private boolean iv_isvibrator_isfront=false;
	private boolean iv_ismoney_isfront=false;
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
		view = inflater.inflate(R.layout.fragment_main_firstpager, null);
		iv_iscomputer=(ImageView) view.findViewById(R.id.iscomputer);
		ll_iscomputer=(LinearLayout) view.findViewById(R.id.layout_iscomputer);
		iv_isvibrator=(ImageView) view.findViewById(R.id.isvibrator);
		ll_isvibrator=(LinearLayout) view.findViewById(R.id.layout_isvibrator);
		iv_ismoney=(ImageView) view.findViewById(R.id.ismoney);
		ll_ismoney=(LinearLayout) view.findViewById(R.id.layout_ismoney);
		ll_iscomputer.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(!iv_iscomputer_isfront){
					iv_iscomputer.setImageResource(R.drawable.switch_front);
					iv_iscomputer_isfront=true;
				}
				else{
					iv_iscomputer.setImageResource(R.drawable.switch_back);
					iv_iscomputer_isfront=false;
				}
			}
		});
		ll_isvibrator.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(!iv_isvibrator_isfront){
					iv_isvibrator.setImageResource(R.drawable.switch_front);
					iv_isvibrator_isfront=true;
				}
				else{
					iv_isvibrator.setImageResource(R.drawable.switch_back);
					iv_isvibrator_isfront=false;
				}
			}
		});
		ll_ismoney.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(!iv_ismoney_isfront){
					iv_ismoney.setImageResource(R.drawable.switch_front);
					iv_ismoney_isfront=true;
				}
				else{
					iv_ismoney.setImageResource(R.drawable.switch_back);
					iv_ismoney_isfront=false;
				}
			}
		});
		return view;
	}

}
