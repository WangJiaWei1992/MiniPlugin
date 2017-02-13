package com.example.wangjiawei.testplugin;

import com.example.wangjiawei.pluginlibrary.PluginApplication;

/**
 * Created by WangJiaWei on 2017/2/13.
 */

public class MainApp extends PluginApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            AMSHookHelper.hookActivityManagerNative();
            AMSHookHelper.hookActivityThreadHandler();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
