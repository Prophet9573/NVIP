package com.zhht.nvip;



import com.zhht.fragment.FifthPager;
import com.zhht.fragment.FirstPager;
import com.zhht.fragment.FourthPager;
import com.zhht.fragment.SecondPager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class NVIPActivity extends FragmentActivity  implements OnClickListener {
	
	int bottom = 0;
	private FirstPager firstpager;
	private SecondPager secondpager;
	// private ThirdPager thirdpager;
	private FourthPager fourthpager;
	private FifthPager fifthpager;
	// 使用布局添加导航栏的按钮监听。
	private LinearLayout first, second, fourth, fifth;
	ImageView iv_menu[] = new ImageView[4];
	private int[] iv_menu_id = { R.id.iv_menu_0, R.id.iv_menu_1,
			R.id.iv_menu_3, R.id.iv_menu_4 };
	private int[] select_on = { R.drawable.bt_menu_0_select,
			R.drawable.bt_menu_1_select, R.drawable.bt_menu_3_select,
			R.drawable.bt_menu_4_select };
	private int[] select_off = { R.drawable.guide_home_on,
			R.drawable.guide_tfaccount_on, R.drawable.guide_cart_on,
			R.drawable.guide_account_on };
	
    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initview();
    }

	private void initview() {
		for (int i = 0; i < select_on.length; i++) {
			iv_menu[i] = (ImageView) findViewById(iv_menu_id[i]);
		}
		// iv_first=(ImageView) findViewById(R.id.iv_menu_0);
		// mainViewPager=(ViewPager)findViewById(R.id.main_viewpager);
		first = (LinearLayout) findViewById(R.id.ll_firstpager);
		second = (LinearLayout) findViewById(R.id.ll_secondpager);
		// third=(LinearLayout) findViewById(R.id.ll_thirdpager);
		fourth = (LinearLayout) findViewById(R.id.ll_fourthpager);
		fifth = (LinearLayout) findViewById(R.id.ll_fifthpager);
		// 为导航栏Button添加监听事件。
		addListener();
		// 默认设置第一个按钮为选中状态״̬
		iv_menu[0].setImageResource(select_off[0]);
		
		if (firstpager == null) {
			firstpager = new FirstPager();
			addFragment(firstpager);
		}
		showFragment(firstpager);
	}
	public void addListener() {
		first.setOnClickListener(this);
		second.setOnClickListener(this);
		// third.setOnClickListener(this);
		fourth.setOnClickListener(this);
		fifth.setOnClickListener(this);

	}
	// 添加Fragment
	public void addFragment(Fragment fragment) {
		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		transaction.add(R.id.main_fragment_group, fragment);
		transaction.commit();

	}

	// 删除Fragment
	public void removeFragment(Fragment fragment) {
		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		transaction.remove(fragment);
		transaction.commit();

	}

	// 显示指定的Fragment,同时讲其他的fragment隐藏。
	public void showFragment(Fragment fragment) {
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

		if (firstpager != null) {
			ft.hide(firstpager);
		}
		if (secondpager != null) {
			ft.hide(secondpager);
		}
		
		if (fourthpager != null) {
			ft.hide(fourthpager);
		}
		if (fifthpager != null) {
			ft.hide(fifthpager);
		}

		ft.show(fragment);
		ft.commitAllowingStateLoss();

	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ll_firstpager:
			iv_menu[0].setImageResource(select_off[0]);
			iv_menu[1].setImageResource(select_on[1]);
			iv_menu[2].setImageResource(select_on[2]);
			iv_menu[3].setImageResource(select_on[3]);
			bottom = 0;
			if (firstpager == null) {
				firstpager = new FirstPager();
				addFragment(firstpager);
				showFragment(firstpager);
			} else if (firstpager.isHidden()) {
				showFragment(firstpager);
			}
			break;
		case R.id.ll_secondpager:
			iv_menu[0].setImageResource(select_on[0]);
			iv_menu[1].setImageResource(select_off[1]);
			iv_menu[2].setImageResource(select_on[2]);
			iv_menu[3].setImageResource(select_on[3]);
			bottom = 1;
			if (secondpager == null) {
				secondpager = new SecondPager();
				addFragment(secondpager);
				showFragment(secondpager);
			} else if (secondpager.isHidden()) {
				showFragment(secondpager);
			}
			break;
		case R.id.ll_fourthpager:
			iv_menu[0].setImageResource(select_on[0]);
			iv_menu[1].setImageResource(select_on[1]);
			iv_menu[2].setImageResource(select_off[2]);
			iv_menu[3].setImageResource(select_on[3]);
			bottom = 1;
			if (fourthpager == null) {
				fourthpager = new FourthPager();
				addFragment(fourthpager);
				showFragment(fourthpager);
			} else if (fourthpager.isHidden()) {
				showFragment(fourthpager);
			}
			break;
		case R.id.ll_fifthpager:
			iv_menu[0].setImageResource(select_on[0]);
			iv_menu[1].setImageResource(select_on[1]);
			iv_menu[2].setImageResource(select_on[2]);
			iv_menu[3].setImageResource(select_off[3]);
			bottom = 1;
			if (fifthpager == null) {
				fifthpager = new FifthPager();
				addFragment(fifthpager);
				showFragment(fifthpager);
			} else if (fifthpager.isHidden()) {
				showFragment(fifthpager);

			}
			break;
		}
	}
}