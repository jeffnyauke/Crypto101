/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.piestack.crypto;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;

import com.piestack.crypto.di.component.AppComponent;
import com.piestack.crypto.di.component.DaggerAppComponent;
import com.piestack.crypto.di.module.AppModule;


public class MyApplication extends Application {

    private AppComponent appComponent;
    @SuppressLint("StaticFieldLeak")
    private static Context context;

    public static AppComponent getComponent(Context context) {
        return ((MyApplication) context.getApplicationContext()).appComponent;
    }

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

}
