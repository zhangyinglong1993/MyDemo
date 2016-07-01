package com.zyl.mydemo.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yinglong.zhang on 2016/7/1.
 */
public class ExitUtil {
    private List<Activity> activityList = new ArrayList<Activity>();

    private static ExitUtil instance = null;

    public ExitUtil() {
    }

    // 单例模式中获取唯一的Mapplication实例
    public static ExitUtil getInstance() {
        if (null == instance) {
            instance = new ExitUtil();
        }
        return instance;
    }

    // 添加Activity到容器中
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    // Activity finish
    public void exit() {

        for (Activity activity : activityList) {
            if (activity != null) {

                activity.finish();
            }
        }
    }

    public void removeActivity(Activity activity) {
        activityList.remove(activity);
    }

    // 移除activity
    public void removeActivity() {

        activityList.removeAll(activityList);
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }

    public Activity getTop() {
        if (activityList != null && activityList.size() > 0) {
            return activityList.get(0);
        }
        return null;
    }
}
