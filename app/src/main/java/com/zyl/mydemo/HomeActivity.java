package com.zyl.mydemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.zyl.mydemo.tab.ui.TabActivity;

/**
 * yinglong.zhang  2016/7/1 开启
 */
public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout llTab;

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
    }
    /**
     * 设置监听
     */
    private void setListener() {
        llTab.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_tab:
                Intent tab = new Intent(this, TabActivity.class);
                startActivity(tab);
                break;

            default:
                break;

        }
    }
}
