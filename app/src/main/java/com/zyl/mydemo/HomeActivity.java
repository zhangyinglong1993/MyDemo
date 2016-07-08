package com.zyl.mydemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.zyl.mydemo.imagePlay.ui.ImagePlayActivity;
import com.zyl.mydemo.tab.ui.TabActivity;

/**
 * yinglong.zhang  2016/7/1 开启
 */
public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout llTab;
    private LinearLayout llLunbo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initTitle();
        initView();
        setListener();
    }
    /**
     * 初始化 组件
     */
    private void initView() {
        tvTitle.setText("Home");
        llTab = (LinearLayout) findViewById(R.id.ll_tab);
        llLunbo = (LinearLayout) findViewById(R.id.ll_lunbo);
    }
    /**
     * 设置监听
     */
    private void setListener() {
        llTab.setOnClickListener(this);
        llLunbo.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_tab://tab切换
                Intent tab = new Intent(this, TabActivity.class);
                startActivity(tab);
                break;
            case R.id.ll_lunbo://轮播
                Intent imagePlay = new Intent(this, ImagePlayActivity.class);
                startActivity(imagePlay);
                break;
            default:
                break;

        }
    }
}
