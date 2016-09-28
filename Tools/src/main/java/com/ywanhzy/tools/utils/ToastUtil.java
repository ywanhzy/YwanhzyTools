package com.ywanhzy.tools.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * @ClassName: ToastUtil
 * @Description: 自定义Toast 不会出现toast过多的重复显示的情况
 * @author liumu
 * @date 2015-3-14 下午4:06:00
 */

public class ToastUtil {

    private static Toast toast;

    public static void showToast(Context context, String msg) {
        if (context == null)
            return;
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        if (toast != null)
            toast.show();
    }

    public static void showToast(Context context, int resId) {
        if (context == null)
            return;
        if (toast == null) {
            toast = Toast.makeText(context, resId, Toast.LENGTH_SHORT);
        } else {
            toast.setText(resId);
        }
        toast.show();
    }

    public static void showToastLong(Context context, int resId) {
        if (context == null)
            return;
        if (toast == null) {
            toast = Toast.makeText(context, resId, Toast.LENGTH_LONG);
        } else {
            toast.setText(resId);
        }
        toast.show();
    }

    public static void showToastLong(Context context, String msg) {
        if (context == null)
            return;
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }
    
    public static void showToastLong(Context context, String msg,int millisecond) {
        if (context == null)
            return;
        if (toast == null) {
            toast = Toast.makeText(context, msg, 5000);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }
    
    @SuppressLint("NewApi")
	public static void showToast(Context context , int imageId ,String content , int duration,int height){
        //new一个toast传入要显示的activity的上下文
        Toast toast = new Toast(context);
        //显示的时间
        toast.setDuration(duration);
        //显示的位置
        toast.setGravity(Gravity.RIGHT|Gravity.BOTTOM, 25, height);
        //重新给toast进行布局
        LinearLayout toastLayout = new LinearLayout(context);
        toastLayout.setOrientation(LinearLayout.HORIZONTAL);
        toastLayout.setGravity(Gravity.CENTER_VERTICAL);
       
        TextView textView = new TextView(context);
        textView.setText(content);
        
        textView.setTextColor(Color.parseColor("#d4b776"));
        textView.setTextSize(18);
//        textView.setBackgroundColor(Color.GRAY); //透明Color.TRANSPARENT
        //把textView添加到toastLayout的布局当中
        toastLayout.addView(textView);      
        toastLayout.setBackgroundColor(0); // 设置背景色  
        //toastLayout.setAlpha(0);
        
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(imageId);
        //把imageView添加到toastLayout的布局当中
        toastLayout.addView(imageView);
        //把toastLayout添加到toast的布局当中
        toast.setView(toastLayout);
        toast.show();
    }
    
}
