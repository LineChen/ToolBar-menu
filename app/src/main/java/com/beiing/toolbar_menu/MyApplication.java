package com.beiing.toolbar_menu;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by linechen on 2017/8/8.<br/>
 * 描述：
 * </br>
 */

public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(
                                Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(
                                Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }
}
