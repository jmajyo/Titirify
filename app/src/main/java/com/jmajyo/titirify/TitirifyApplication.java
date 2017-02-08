package com.jmajyo.titirify;

import android.app.Application;

import io.realm.Realm;

public class TitirifyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
