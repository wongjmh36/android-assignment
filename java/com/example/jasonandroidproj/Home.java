package com.example.jasonandroidproj;

import android.app.Application;
import android.content.Context;

public class Home extends Application {
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, "en"));
    }
}
