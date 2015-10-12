package com.yiyazhe.utils;

import android.app.Activity;

/**
 * 获取屏幕宽度工具类
 *
 * Author：JiangChu
 * Date：2015/10/11
 */
public class ScreenSizeUtil {

	public static int getScreenWidth(Activity activity) {
		return activity.getWindowManager().getDefaultDisplay().getWidth();
	}

	public static int getScreenHeight(Activity activity) {
		return activity.getWindowManager().getDefaultDisplay().getHeight();
	}

}
