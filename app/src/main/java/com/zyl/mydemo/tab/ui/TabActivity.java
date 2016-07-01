package com.zyl.mydemo.tab.ui;

import android.os.Bundle;
import android.view.View;

import com.zyl.mydemo.BaseActivity;
import com.zyl.mydemo.R;

/**
 * Created by yinglong.zhang on 2016/7/1.
 */
public class TabActivity extends BaseActivity implements View.OnClickListener {

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
        tvBack.setVisibility(View.VISIBLE);



    }

    private void setListener() {
        tvBack.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
                finish();
                break;
            default:
                break;
        }
    }
}
