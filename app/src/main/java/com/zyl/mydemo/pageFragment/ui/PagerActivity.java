package com.zyl.mydemo.pageFragment.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.zyl.mydemo.BaseActivity;
import com.zyl.mydemo.R;
import com.zyl.mydemo.pageFragment.adapter.MyFragmentAdapter;
import com.zyl.mydemo.pageFragment.ui.fragment.AFragment;
import com.zyl.mydemo.pageFragment.ui.fragment.BFragment;
import com.zyl.mydemo.pageFragment.ui.fragment.CFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yinglong.zhang on 2016/7/12.
 */
public class PagerActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener, ViewPager.OnPageChangeListener {

    private ViewPager vpFragment;
    private RadioGroup rgPager;
    private MyFragmentAdapter adapter;
    private List<Fragment> fragments;
    private TextView tvLine;
    private int totalWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        initTitle();
        initView();
        setListener();

    }
    private void initView() {

        tvTitle.setText("ViewPager+Fragment");
        ivBack.setVisibility(View.VISIBLE);
        vpFragment = (ViewPager) findViewById(R.id.vp_fragment);
        rgPager = (RadioGroup) findViewById(R.id.rg_page);
        adapter = new MyFragmentAdapter(getSupportFragmentManager());
        fragments = new ArrayList<Fragment>();
        AFragment aFragment = new AFragment();
        BFragment bFragment = new BFragment();
        CFragment cFragment = new CFragment();
        fragments.add(aFragment);
        fragments.add(bFragment);
        fragments.add(cFragment);

        adapter.setList(fragments);
        vpFragment.setAdapter(adapter);

        tvLine = (TextView) findViewById(R.id.tv_line);
        totalWidth = getWindowManager().getDefaultDisplay().getWidth();
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tvLine.getLayoutParams();
        params.width = totalWidth/3;
        tvLine.setLayoutParams(params);


    }
    private void setListener() {

        ivBack.setOnClickListener(this);
        rgPager.setOnCheckedChangeListener(this);
        vpFragment.addOnPageChangeListener(this);

    }
    public void maginLeft(int num) {
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tvLine.getLayoutParams();
        params.leftMargin = (params.width * num);
        tvLine.setLayoutParams(params);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_a:
                maginLeft(0);
                vpFragment.setCurrentItem(0);
                break;
            case R.id.rb_b:
                maginLeft(1);
                vpFragment.setCurrentItem(1);
                break;
            case R.id.rb_c:
                maginLeft(2);
                vpFragment.setCurrentItem(2);
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch(position){
            case 0:
                rgPager.check(R.id.rb_a);
                break;
            case 1:
                rgPager.check(R.id.rb_b);
                break;
            case 2:
                rgPager.check(R.id.rb_c);
                break;
            default:
                break;
        }


    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
