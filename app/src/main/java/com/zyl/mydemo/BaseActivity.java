package com.zyl.mydemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import com.zyl.mydemo.util.ExitUtil;
import com.zyl.mydemo.util.ToastUtils;

/**
 * Created by yinglong.zhang on 2016/7/1.
 */
public class BaseActivity extends Activity {

    public TextView tvBack,tvTitle,tvNext;

    /**
     *  返回键 退出时间
     */
    private long firstTime, spaceTime, secondTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ExitUtil.getInstance().addActivity(this);
        initTitle();
    }
    /**
     * 初始化标题
     */
    public void initTitle() {
        tvBack = (TextView) findViewById(R.id.tv_back);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvNext = (TextView) findViewById(R.id.tv_next);
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        String currentActivityName = this.getClass().getSimpleName();
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0
                && currentActivityName.equals("HomeActivity")) {
            firstTime = System.currentTimeMillis();
            spaceTime = firstTime - secondTime;
            secondTime = firstTime;
            if (spaceTime > 2000) {
                ToastUtils.toastLong(this, "点击第二次退出");
                return false;
            } else {
                ExitUtil.getInstance().exit();
            }
        }
        else {
            finish();
        }

        return super.onKeyDown(keyCode, event);
    }


}
