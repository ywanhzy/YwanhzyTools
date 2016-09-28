package com.ywanhzy.tools.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 
 * @ClassName: SharedPreferencesUtils
 * @Description: 调用setParam就能保存String, Integer, Boolean, Float, Long类型的参数
 *               同样调用getParam就能获取到保存在手机里面的数据
 * @author liumu
 * @date 2015-3-15 下午5:24:30
 */
public class SharedPreferencesUtil {
	/**
	 * 保存在手机里面的文件名default
	 */
	private static final String DEFAULT_FILE_NAME = "ywanhzySP";

	/**
	 * 保存数据 <br>
	 * SharedPreferencesUtil.setParam(getApplication(), "home", "city", "长沙");<br>
	 * SharedPreferencesUtil.setParam(getApplication(), "home", "area", "芙蓉区");<br>
	 * SharedPreferencesUtil.setParam(getApplication(), "home", "isCBD", false); <br>
	 * SharedPreferencesUtil.setParam(getApplication(), "home", "money", 10000); <br>
	 * SharedPreferencesUtil.setParam(getApplication(), "home", "areas", 80.5f); <br>
	 * SharedPreferencesUtil.setParam(getApplication(), "home", "time",
	 * 1324564578L);
	 * 
	 * 获取数据 <br>
	 * String ddd= (String)
	 * SharedPreferencesUtil.getParam(getApplication(),"home", "city",""); <br>
	 * SharedPreferencesUtil.getParam(getApplication(),"home", "area",""); <br>
	 * SharedPreferencesUtil.getParam(getApplication(),"home", "money", 0); <br>
	 * SharedPreferencesUtil.getParam(getApplication(),"home", "isCBD", false); <br>
	 * SharedPreferencesUtil.getParam(getApplication(),"home", "time", 0L); <br>
	 * SharedPreferencesUtil.getParam(getApplication(),"home", "areas", 0.0f);
	 */

	/**
	 * 
	 * @Title: setParam
	 * @Description: 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
	 * @param context
	 * @param fileName
	 * @param key
	 *            值--"String","Integer","Boolean","Float","Long"
	 * @param object
	 * @return void
	 * 
	 * @author liumu
	 * @date 2015-3-15 下午5:44:08
	 */
	public static void setParam(Context context, String fileName, String key,
			Object object) {
		if (StringUtils.isEmpty(fileName)) {
			fileName = DEFAULT_FILE_NAME;
		}

		String type = object.getClass().getSimpleName();
		SharedPreferences sp = context.getSharedPreferences(fileName,
				Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sp.edit();

		if ("String".equals(type)) {
			editor.putString(key, (String) object);
		} else if ("Integer".equals(type)) {
			editor.putInt(key, (Integer) object);
		} else if ("Boolean".equals(type)) {
			editor.putBoolean(key, (Boolean) object);
		} else if ("Float".equals(type)) {
			editor.putFloat(key, (Float) object);
		} else if ("Long".equals(type)) {
			editor.putLong(key, (Long) object);
		}

		editor.commit();
	}

	/**
	 * 
	 * @Title: getParam
	 * @Description: 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
	 * @param context
	 * @param fileName
	 * @param key
	 *            值--"String","Integer","Boolean","Float","Long"
	 * @param defaultObject
	 * @return Object
	 * 
	 * @author liumu
	 * @date 2015-3-15 下午10:45:29
	 */
	public static Object getParam(Context context, String fileName, String key,
			Object defaultObject) {
		if (StringUtils.isEmpty(fileName)) {
			fileName = DEFAULT_FILE_NAME;
		}
		String type = defaultObject.getClass().getSimpleName();
		SharedPreferences sp = context.getSharedPreferences(fileName,
				Context.MODE_PRIVATE);

		if ("String".equals(type)) {
			return sp.getString(key, (String) defaultObject);
		} else if ("Integer".equals(type)) {
			return sp.getInt(key, (Integer) defaultObject);
		} else if ("Boolean".equals(type)) {
			return sp.getBoolean(key, (Boolean) defaultObject);
		} else if ("Float".equals(type)) {
			return sp.getFloat(key, (Float) defaultObject);
		} else if ("Long".equals(type)) {
			return sp.getLong(key, (Long) defaultObject);
		}

		return null;
	}

}