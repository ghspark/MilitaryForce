package com.gh.app.militaryforce.util;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by gaohang on 15/9/20.
 */
public class SharedPreUtil {


        public static Boolean getBooleanShared(Activity activity,String tag,String key,Boolean defaultValue) {
            Boolean result;
            SharedPreferences sharedPreferences=activity.getSharedPreferences(tag, Activity.MODE_PRIVATE);
            result=sharedPreferences.getBoolean(key,defaultValue);
            return result;
        }

}
