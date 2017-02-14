package com.example.wangjiawei.pluginlibrary;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

import dalvik.system.DexClassLoader;
import dalvik.system.DexFile;

/**
 * Created by WangJiaWei on 2017/2/14.
 */
public class BaseDexClassLoaderHookHelper {

    public static void patchClassLoader(ClassLoader classLoader, File apkFile, File optDexFile) throws Exception {
        Field pathListField = DexClassLoader.class.getSuperclass().getDeclaredField("pathList");
        pathListField.setAccessible(true);
        Object pathListObj = pathListField.get(classLoader);

        Field dexElementArray = pathListObj.getClass().getDeclaredField("dexElements");
        dexElementArray.setAccessible(true);
        Object[] dexElements = (Object[]) dexElementArray.get(pathListObj);

        Class<?> elementClass = dexElements.getClass().getComponentType();

        Object[] newElements = (Object[]) Array.newInstance(elementClass, dexElements.length + 1);

        Constructor<?> constructor = elementClass.getConstructor(File.class, boolean.class, File.class, DexFile.class);
        Object o = constructor.newInstance(apkFile, false, apkFile, DexFile.loadDex(apkFile.getCanonicalPath(), optDexFile.getAbsolutePath(), 0));

        Object[] toAddElementArray = new Object[] { o };
        System.arraycopy(dexElements, 0, newElements, 0, dexElements.length);
        System.arraycopy(toAddElementArray, 0, newElements, dexElements.length, toAddElementArray.length);

        dexElementArray.set(pathListObj, newElements);
    }
}
