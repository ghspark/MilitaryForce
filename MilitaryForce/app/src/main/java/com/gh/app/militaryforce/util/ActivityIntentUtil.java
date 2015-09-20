package com.gh.app.militaryforce.util;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by gaohang on 15/9/20.
 */
public class ActivityIntentUtil {

    public static void ActivityJump(Activity activity,Class myclass){
        Intent itent=new Intent();
        itent.setClass(activity,myclass);
        activity.startActivity(itent);
    }
}
