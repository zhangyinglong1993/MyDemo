
package com.zyl.mydemo.util;


import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zyl.mydemo.R;


/**
 * 吐司工具类
 */
public class ToastUtils {

    public static void toastShort(Context context, String msg) {
        try {
            View toastView = LayoutInflater.from(context).inflate(R.layout.layout_view_toast, null);
            TextView mTvToast = (TextView) toastView.findViewById(R.id.tv_toast);
            mTvToast.setText(msg);
            Toast toast = new Toast(context);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(toastView);
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void toastLong(Context context, String msg) {
        try {
            View toastView = LayoutInflater.from(context).inflate(R.layout.layout_view_toast, null);
            TextView mTvToast = (TextView) toastView.findViewById(R.id.tv_toast);
            mTvToast.setText(msg);
            Toast toast = new Toast(context);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(toastView);
            toast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 哭脸
    // public static void toastCry(Context context) {
    // View toastView = LayoutInflater.from(context)
    // .inflate(R.layout.layout_imageview_toast, null);
    // ImageView iv = (ImageView) toastView.findViewById(R.id.iv_toast);
    // iv.setBackgroundResource(R.drawable.emoticon_sad);
    // Toast toast = new Toast(context);
    // toast.setDuration(Toast.LENGTH_SHORT);
    // toast.setView(toastView);
    // toast.show();
    // }
    //
    // // 笑脸
    // public static void toastSmile(Context context) {
    // View toastView = LayoutInflater.from(context)
    // .inflate(R.layout.layout_imageview_toast, null);
    // ImageView iv = (ImageView) toastView.findViewById(R.id.iv_toast);
    // iv.setBackgroundResource(R.drawable.emoticon_smile);
    // Toast toast = new Toast(context);
    // toast.setDuration(Toast.LENGTH_SHORT);
    // toast.setView(toastView);
    // toast.show();
    // }
    //
    // 成功
    public static void toastSuccess(Context context, String title) {
        View toastView = LayoutInflater.from(context).inflate(R.layout.layout_main_toast, null);
        ImageView iv = (ImageView) toastView.findViewById(R.id.iv_toast);
        TextView tv = (TextView) toastView.findViewById(R.id.tv_show);
        tv.setVisibility(View.VISIBLE);
        tv.setText(title);
        iv.setImageResource(R.mipmap.ic_contacts_yes);
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(toastView);
        toast.show();
    }

    // 失败
    public static void toastFail(Context context, String title) {
        View toastView = LayoutInflater.from(context).inflate(R.layout.layout_main_toast, null);
        ImageView iv = (ImageView) toastView.findViewById(R.id.iv_toast);
        TextView tv = (TextView) toastView.findViewById(R.id.tv_show);
        tv.setVisibility(View.VISIBLE);
        tv.setText(title);
        iv.setImageResource(R.mipmap.ic_contacts_no);
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(toastView);
        toast.show();
    }
    /**
     * 提示
     */
    public static void toastAlert(Context context, String title) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_main_toast, null);
        TextView tv = (TextView) view.findViewById(R.id.tv_show);
        tv.setVisibility(View.VISIBLE);
        tv.setText(title);
        Toast toast = new Toast(context);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();
    }
}
