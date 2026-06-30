package com.example.bthook;

import io.github.libxposed.api.XposedModule;

public class Main extends XposedModule {

    @Override
    public void onModuleLoaded(
            ModuleLoadedParam param)
            throws Throwable {

        log(android.util.Log.INFO,
                "BTHOOK",
                "module loaded");
    }
}
