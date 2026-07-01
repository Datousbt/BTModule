package com.datousbt.btautomation.hook;

import android.util.Log;

import io.github.libxposed.api.XposedModule;
import io.github.libxposed.api.XposedModuleInterface;

public class MainHook
        extends XposedModule
        implements XposedModuleInterface {

    public MainHook(
            ModuleLoadedParam param) {

        super(param);
    }

    @Override
    public void onPackageLoaded(
            PackageLoadedParam param)
            throws Throwable {

        if (!"android".equals(
                param.getPackageName()))
            return;

        Log.e(
                "DiPlus",
                "android package loaded");

        ClassLoader cl =
                param.getClassLoader();

        String[] targets = {

                "com.android.server.BluetoothManagerService",

                "com.android.server.BluetoothManagerServiceStub",

                "com.android.bluetooth.btservice.AdapterService",

                "com.android.bluetooth.btservice.ActiveDeviceManager",

                "com.android.bluetooth.btservice.PhonePolicy",

                "com.android.bluetooth.btservice.AdapterProperties"
        };

        for (String name : targets) {

            try {

                Class<?> clazz =
                        cl.loadClass(name);

                Log.e(
                        "DiPlus",
                        "FOUND: "
                                + clazz.getName());

            } catch (Throwable e) {

                Log.e(
                        "DiPlus",
                        "MISS: "
                                + name);
            }
        }
    }
}