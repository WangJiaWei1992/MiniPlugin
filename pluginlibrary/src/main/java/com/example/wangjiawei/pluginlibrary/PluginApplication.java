package com.example.wangjiawei.pluginlibrary;

import android.app.Application;

/**
 * Created by WangJiaWei on 2017/2/13.
 */

public class PluginApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
//        try {
//            AMSHookHelper.hookActivityManagerNative();
//            AMSHookHelper.hookActivityThreadHandler();
//        } catch (Throwable e) {
//        }
    }
}
