package com.aflah.libraryku;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by aflah on 30/07/19
 * Email  : aflahtaqiusondha@gmail.com
 * Github : https://github.com/aflahtaqiu
 */


public class ApplicationInfoUtils {

    private Context context;

    public ApplicationInfoUtils(Context context) {
        this.context = context;
    }

    public String getApplicationVersionNumber () {

        if (context == null)
            return null;
        else {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public int getApplicationVersionCode () {

        if (context == null)
            return 0;
        else {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return 0;
            }
        }
    }

    public boolean isServiceRunning (String serviceName) {

        ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo  serviceInfo : activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceInfo.service.getClassName().equals(serviceName))
                return true;
        }

        return false;
    }
}
