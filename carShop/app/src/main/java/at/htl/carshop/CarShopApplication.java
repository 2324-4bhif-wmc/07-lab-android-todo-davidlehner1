package at.htl.carshop;

import android.app.Application;
import android.util.Log;

import javax.inject.Singleton;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
@Singleton
public class CarShopApplication extends Application {

    static final String TAG = CarShopApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "App started ...");
    }

}

