package com.example.wangjiawei.pluginlibrary;

import android.content.ComponentName;
import android.content.Intent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by WangJiaWei on 2017/2/13.
 */
public class ActivityManagerHandler implements InvocationHandler {

    Object mBase;

    public ActivityManagerHandler(Object base) {
        mBase = base;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        if ("startActivity".equals(method.getName())) {
//            Intent raw;
//            int index = 0;
//
//            for (int i = 0; i < args.length; ++i) {
//                if (args[i] instanceof Intent) {
//                    index = i;
//                    break;
//                }
//            }
//            raw = (Intent) args[index];
//
//            Intent newIntent = new Intent();
//            ComponentName componentName = new ComponentName("com.example.wangjiawei.testplugin", StubActivity.class.getName());
//            newIntent.setComponent(componentName);
//
//            newIntent.putExtra(AMSHookHelper.EXTRA_TARGET_INTENT, raw);
//
//            args[index] = newIntent;
//
//            return method.invoke(mBase, args);
//        }
        return method.invoke(mBase, args);
    }
}
