package com.example.wangjiawei.pluginlibrary;

import android.app.Application;
import android.content.Context;

import java.io.File;

/**
 * Created by WangJiaWei on 2017/2/13.
 */

public class PluginApplication extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        try {
            //AMSHookHelper.hookActivityManagerNative();
            //AMSHookHelper.hookActivityThreadHandler();

            Utils.extractAssets(sContext, "plugin.apk");

            File dexFile = getFileStreamPath("plugin.apk");
            File optDexFile = getFileStreamPath("plugin.dex");
            BaseDexClassLoaderHookHelper.patchClassLoader(getClassLoader(), dexFile, optDexFile);
        } catch (Throwable e) {
        }
    }

    public static Context getContext() {
        return sContext;
    }
}
