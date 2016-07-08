package com.zyl.mydemo.imagePlay.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zyl.mydemo.BaseActivity;
import com.zyl.mydemo.R;
import com.zyl.mydemo.imagePlay.adapter.ImageAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/7.
 */
public class ImagePlayActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private LinearLayout llGroup;

    private List<ImageView> views;
    private List<ImageView> tips;

    private ImageAdapter adapter;

    private int currentItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageplay);
        initTitle();
        initView();
        setListener();
        setViewPager();
    }
    private void initView() {

        tvTitle.setText("图片轮播");
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapter = new ImageAdapter(this);
        llGroup = (LinearLayout) findViewById(R.id.ll_group);
        views = new ArrayList<ImageView>();
        tips = new ArrayList<ImageView>();
        initImage();
        initTips();



    }

    /**
     * 初始化轮播图
     */
    private void initImage() {

        ImageView imageView1 = new ImageView(this);
        imageView1.setImageResource(R.mipmap.lunbo1);
        imageView1.setScaleType(ImageView.ScaleType.CENTER_CROP);

        ImageView imageView2 = new ImageView(this);
        imageView2.setImageResource(R.mipmap.lunbo2);
        imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);

        ImageView imageView3 = new ImageView(this);
        imageView3.setImageResource(R.mipmap.lunbo3);
        imageView3.setScaleType(ImageView.ScaleType.CENTER_CROP);

        ImageView imageView4 = new ImageView(this);
        imageView4.setImageResource(R.mipmap.lunbo4);
        imageView4.setScaleType(ImageView.ScaleType.CENTER_CROP);

        views.add(imageView1);
        views.add(imageView2);
        views.add(imageView3);
        views.add(imageView4);
    }

    /**
     * 初始化 tips
     */
    private void initTips() {
        llGroup.removeAllViews();
        for(int i=0;i<views.size();i++) {
            ImageView tip = new ImageView(this);
            tip.setLayoutParams(new ViewGroup.LayoutParams(10,10));
            if(i==0) {
                tip.setImageResource(R.mipmap.ic_dot1);
            }
            else {
                tip.setImageResource(R.mipmap.ic_dot2);
            }
            tips.add(tip);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT));
            layoutParams.leftMargin = 5;
            layoutParams.rightMargin = 5;
            llGroup.addView(tip, layoutParams);

        }

    }

    private void setListener() {
        viewPager.addOnPageChangeListener(this);
    }

    /**
     * 设置轮播
     */
    private void setViewPager() {
        adapter.setList(views);
        viewPager.setAdapter(adapter);
        handler.sendEmptyMessageDelayed(1,3000);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        changeTip(position);
        Message message = new Message();
        message.arg1 = position;
        message.what = 2;
        handler.sendMessage(message);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * 更改 tip
     */
    private void changeTip(int index) {

        for (int i=0;i<tips.size();i++) {
            if(i == index) {
                tips.get(i).setImageResource(R.mipmap.ic_dot1);
            }
            else {
                tips.get(i).setImageResource(R.mipmap.ic_dot2);
            }
        }
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 1) {
                currentItem ++;
                if(currentItem == views.size()) {
                    currentItem = 0;
                }
                viewPager.setCurrentItem(currentItem);
                handler.sendEmptyMessageDelayed(1,3000);
            }
            else if(msg.what == 2) {
                currentItem = msg.arg1;
            }
        }
    };
}
