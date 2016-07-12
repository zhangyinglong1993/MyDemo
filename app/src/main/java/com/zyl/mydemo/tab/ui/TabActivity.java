package com.zyl.mydemo.tab.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioGroup;

import com.zyl.mydemo.BaseActivity;
import com.zyl.mydemo.R;
import com.zyl.mydemo.tab.ui.fragment.FirstFragment;
import com.zyl.mydemo.tab.ui.fragment.FiveFragment;
import com.zyl.mydemo.tab.ui.fragment.FourthFragment;
import com.zyl.mydemo.tab.ui.fragment.SecondFragment;
import com.zyl.mydemo.tab.ui.fragment.ThirdFragment;

/**
 * Created by yinglong.zhang on 2016/7/1.
 */
public class TabActivity extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private RadioGroup rgTab;

    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private ThirdFragment thirdFragment;
    private FourthFragment fourthFragment;
    private FiveFragment fiveFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        initTitle();
        initView();
        setListener();
    }

    private void initView() {

        tvTitle.setText("tab切换界面");
        ivBack.setVisibility(View.VISIBLE);

        rgTab = (RadioGroup) findViewById(R.id.rg_tab);
        fragmentManager = getSupportFragmentManager();


    }

    private void setListener() {
        ivBack.setOnClickListener(this);
        rgTab.setOnCheckedChangeListener(this);
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
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_publish://发布
                transaction = fragmentManager.beginTransaction();
                hideAll(transaction);
                if(firstFragment == null) {
                    firstFragment = new FirstFragment();
                    transaction.add(R.id.fl_container,firstFragment);
                }
                else {
                    transaction.show(firstFragment);
                }
                transaction.commit();

                break;
            case R.id.rb_type://分类
                transaction = fragmentManager.beginTransaction();
                hideAll(transaction);
                if(secondFragment == null) {
                    secondFragment = new SecondFragment();
                    transaction.add(R.id.fl_container,secondFragment);
                }
                else {
                    transaction.show(secondFragment);
                }
                transaction.commit();

                break;
            case R.id.rb_home://主页
                transaction = fragmentManager.beginTransaction();
                hideAll(transaction);
                if(thirdFragment == null) {
                    thirdFragment = new ThirdFragment();
                    transaction.add(R.id.fl_container,thirdFragment);
                }
                else {
                    transaction.show(thirdFragment);
                }
                transaction.commit();
                break;
            case R.id.rb_msg://消息
                transaction = fragmentManager.beginTransaction();
                hideAll(transaction);
                if(fourthFragment == null) {
                    fourthFragment = new FourthFragment();
                    transaction.add(R.id.fl_container,fourthFragment);
                }
                else {
                    transaction.show(fourthFragment);
                }
                transaction.commit();
                break;
            case R.id.rb_me://我的
                transaction = fragmentManager.beginTransaction();
                hideAll(transaction);
                if(fiveFragment == null) {
                    fiveFragment = new FiveFragment();
                    transaction.add(R.id.fl_container,fiveFragment);
                }
                else {
                    transaction.show(fiveFragment);
                }
                transaction.commit();
                break;
            default:
                break;
        }
    }
    /**
     * 隐藏所有fragment
     */
    private void hideAll(FragmentTransaction transaction) {
        if(firstFragment != null) {
            transaction.hide(firstFragment);
        }
        if(secondFragment != null) {
            transaction.hide(secondFragment);
        }
        if(thirdFragment != null) {
            transaction.hide(thirdFragment);
        }
        if(fourthFragment != null) {
            transaction.hide(fourthFragment);
        }
        if(fiveFragment != null) {
            transaction.hide(fiveFragment);
        }
    }
}
