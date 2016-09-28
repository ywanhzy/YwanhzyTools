package com.ywanhzy.tools.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.Log;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 *
 * 设备相关工具类
 *
 */
public class DeviceUtils {

    private DeviceUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 获取设备MAC地址
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>}</p>
     *
     * @param context 上下文
     * @return MAC地址
     */
    public static String getMacAddress(Context context) {
        WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifi.getConnectionInfo();
        if (info != null) {
            String macAddress = info.getMacAddress();
            if (macAddress != null) {
                return macAddress.replace(":", "");
            }
        }
        return null;
    }

    /**
     * 获取设备MAC地址
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>}</p>
     *
     * @return MAC地址
     */

    public static String getMacAddress() {
        String macAddress = null;
        LineNumberReader lnr = null;
        InputStreamReader isr = null;
        try {
            Process pp = Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address");
            isr = new InputStreamReader(pp.getInputStream());
            lnr = new LineNumberReader(isr);
            macAddress = lnr.readLine().replace(":", "");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            FileUtils.closeIO(lnr, isr);
        }
        return macAddress == null ? "" : macAddress;
    }

    /**
     * 获取设备厂商，如Xiaomi
     *
     * @return 设备厂商
     */
    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    /**
     * 获取设备型号，如MI2SC
     *
     * @return 设备型号
     */
    public static String getModel() {
        String model = Build.MODEL;
        if (model != null) {
            model = model.trim().replaceAll("\\s*", "");
        } else {
            model = "";
        }
        return model;
    }
    public static String getPhoneInfo() {
        String phoneInfo = "Product: " + android.os.Build.PRODUCT;   //手机厂商
        phoneInfo += ", CPU_ABI: " + android.os.Build.CPU_ABI;  //CPU 和ABI的本地代码指令集
        phoneInfo += ", TAGS: " + android.os.Build.TAGS;  //描述Build的标签
        phoneInfo += ", VERSION_CODES.BASE: "
                + android.os.Build.VERSION_CODES.BASE;
        phoneInfo += ", MODEL: " + android.os.Build.MODEL;  //版本
        phoneInfo += ", SDK: " + android.os.Build.VERSION.SDK;  //SDK版本
        phoneInfo += ", VERSION.RELEASE: " + android.os.Build.VERSION.RELEASE; //系统版本
        phoneInfo += ", DEVICE: " + android.os.Build.DEVICE;  //设备参数
        phoneInfo += ", DISPLAY: " + android.os.Build.DISPLAY;  //显示屏参数
        phoneInfo += ", BRAND: " + android.os.Build.BRAND;  //品牌
        phoneInfo += ", BOARD: " + android.os.Build.BOARD;
        phoneInfo += ", FINGERPRINT: " + android.os.Build.FINGERPRINT;  //硬件名
        phoneInfo += ", ID: " + android.os.Build.ID;  //修改版本列表
        phoneInfo += ", MANUFACTURER: " + android.os.Build.MANUFACTURER;  //硬件厂商
        phoneInfo += ", USER: " + android.os.Build.USER;
        return phoneInfo;
    }

}