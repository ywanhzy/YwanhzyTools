package com.ywanhzy.tools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.util.Log;

import java.util.List;

import static android.content.Context.ACTIVITY_SERVICE;

/**
 * Created by Administrator on 2016/9/26.
 */

public class AppUtil {
    public static boolean isServiceRunning(String serviceClassName,Context context){
        final ActivityManager activityManager = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
        final List<RunningServiceInfo> services = activityManager.getRunningServices(Integer.MAX_VALUE);

        for (RunningServiceInfo runningServiceInfo : services) {
            if (runningServiceInfo.service.getClassName().equals(serviceClassName)){
                return true;
            }
        }
        return false;
    }
    /**
     * 检测某Activity是否在当前Task的栈顶
     */
    public boolean isTopActivy(String cmdName,Context context){
        ActivityManager manager = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
        List<RunningTaskInfo> runningTaskInfos = manager.getRunningTasks(1);
        String cmpNameTemp = null;
        if(null != runningTaskInfos){
            cmpNameTemp=(runningTaskInfos.get(0).topActivity).toString();
            Log.e("cmpname","cmpname:"+cmpNameTemp);
        }
        if(null == cmpNameTemp)return false;
        return cmpNameTemp.equals(cmdName);
    }

    /**
     * 判断app是否正在运行
     * @param ctx
     * @param packageName
     * @return
     */
    public boolean appIsRunning(Context ctx,String packageName)
    {
        ActivityManager am = (ActivityManager) ctx.getSystemService(ACTIVITY_SERVICE);

        List<RunningAppProcessInfo> runningAppProcesses = am.getRunningAppProcesses();

        if(runningAppProcesses!=null)
        {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {

                if(runningAppProcessInfo.processName.startsWith(packageName))
                {
                    return true;
                }
            }
        }

        return false;
    }
    /**
     * app 是否在后台运行
     * @param ctx
     * @param packageName
     * @return
     */
    public boolean appIsBackgroundRunning(Context ctx,String packageName)
    {
        ActivityManager am = (ActivityManager) ctx.getSystemService(ACTIVITY_SERVICE);

        List<RunningAppProcessInfo> runningAppProcesses = am.getRunningAppProcesses();

        if(runningAppProcesses!=null)
        {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {

                if(runningAppProcessInfo.processName.startsWith(packageName))
                {
                    return runningAppProcessInfo.importance!=RunningAppProcessInfo.IMPORTANCE_FOREGROUND && runningAppProcessInfo.importance!=RunningAppProcessInfo.IMPORTANCE_VISIBLE; //排除无界面的app
                }
            }
        }

        return false;
    }
}
